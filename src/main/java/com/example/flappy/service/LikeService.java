package com.example.flappy.service;

import com.example.flappy.model.Like;
import com.example.flappy.model.Post;
import com.example.flappy.model.User;
import com.example.flappy.repository.LikeRepository;
import com.example.flappy.repository.PostRepository;
import com.example.flappy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    public String likePost(Long userId, Long postId) {
        if (likeRepository.existsByUserIdAndPostId(userId, postId)) {
            return "Already liked";
        }
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        Like like = new Like();
        like.setUser(user);
        like.setPost(post);
        likeRepository.save(like);
        return "Liked";
    }

    public long countLikes(Long postId) {
        return likeRepository.countByPostId(postId);
    }
}