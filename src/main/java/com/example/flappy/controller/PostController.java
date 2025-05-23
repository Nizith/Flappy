package com.example.flappy.controller;

import com.example.flappy.model.Post;
import com.example.flappy.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public Post createPost(@RequestParam Long userId, @RequestBody String content) {
        return postService.createPost(userId, content);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable Long id) {
        return postService.getPostById(id).orElseThrow(() -> new RuntimeException("Post not found"));
    }
}