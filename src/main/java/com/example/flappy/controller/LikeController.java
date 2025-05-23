package com.example.flappy.controller;

import com.example.flappy.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping
    public String likePost(@RequestParam Long userId, @RequestParam Long postId) {
        return likeService.likePost(userId, postId);
    }

    @GetMapping("/count")
    public long countLikes(@RequestParam Long postId) {
        return likeService.countLikes(postId);
    }
}
