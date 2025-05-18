package com.example.flappy.service;

import com.example.flappy.model.Post;
import com.example.flappy.model.User;
import com.example.flappy.repository.PostRepository;
import com.example.flappy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Post createPost(Long userId, String content) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (!userOpt.isPresent()) throw new RuntimeException("User not found");
        Post post = new Post();
        post.setUser(userOpt.get());
        post.setContent(content);
        post.setCreatedDate(LocalDateTime.now());
        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }
}