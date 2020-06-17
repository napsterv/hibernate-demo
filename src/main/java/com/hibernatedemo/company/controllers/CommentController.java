package com.hibernatedemo.company.controllers;

import com.hibernatedemo.company.models.PostComment;
import com.hibernatedemo.company.repositories.PostCommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class CommentController {

    private final PostCommentRepository postCommentRepository;

    @GetMapping("comments")
    public List<PostComment> postCommentList() {
        return postCommentRepository.findAll();
    }


    @PostMapping("comments")
    public PostComment createComment(@RequestBody PostComment comment) {
        return postCommentRepository.save(comment);
    }

}
