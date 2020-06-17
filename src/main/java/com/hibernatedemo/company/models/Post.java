package com.hibernatedemo.company.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @JsonManagedReference
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true,
            targetEntity = PostComment.class, fetch = FetchType.EAGER)
    private List<PostComment> comments = new ArrayList<>();

    public void setComments(List<PostComment> comments) {
        for (PostComment comment : comments) {
            comment.setPost(this);
        }
        this.comments = comments;
    }
}
