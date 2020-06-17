package com.hibernatedemo.company.controllers;

import com.hibernatedemo.company.models.Post;
import com.hibernatedemo.company.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;

    @GetMapping("posts")
    public List<Post> listPost() {
        return postRepository.findAll();
    }

    @GetMapping("posts/{postId}")
    public Optional<Post> getPost(@PathVariable Long postId) {
        return postRepository.findById(postId);
    }

    @PostMapping("posts")
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }
}