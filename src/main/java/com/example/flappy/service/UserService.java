package com.example.flappy.service;

import com.example.flappy.model.User;
import com.example.flappy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marks this as a Spring service (for dependency injection)
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(String username){
        User user = new User();
        user.setUsername(username);
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
