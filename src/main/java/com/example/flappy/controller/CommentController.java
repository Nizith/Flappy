package com.example.flappy.controller;

import com.example.flappy.model.Comment;
import com.example.flappy.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment addComment(@RequestParam Long userId, @RequestParam Long postId, @RequestBody String content) {
        return commentService.addComment(userId, postId, content);
    }
}