package com.example.flappy.service;

import com.example.flappy.model.Comment;
import com.example.flappy.model.Post;
import com.example.flappy.model.User;
import com.example.flappy.repository.CommentRepository;
import com.example.flappy.repository.PostRepository;
import com.example.flappy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    public Comment addComment(Long userId, Long postId, String content) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPost(post);
        comment.setContent(content);
        comment.setCreatedDate(LocalDateTime.now());

        return commentRepository.save(comment);
    }
}