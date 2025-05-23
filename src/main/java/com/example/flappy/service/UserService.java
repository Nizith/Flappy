package com.example.flappy.service;

import com.example.flappy.dto.UserCreateDTO;
import com.example.flappy.dto.UserLoginDTO;
import com.example.flappy.dto.UserResponseDTO;
import com.example.flappy.model.User;
import com.example.flappy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marks this as a Spring service (for dependency injection)
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResponseDTO register(UserCreateDTO userCreateDTO){
        User user = new User();
        user.setUsername(userCreateDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));

        User savedUser = userRepository.save(user);
        return new UserResponseDTO(savedUser.getId(), savedUser.getUsername());
    }

    public UserResponseDTO login(UserLoginDTO userLoginDTO){
        User user = userRepository.findByUsername(userLoginDTO.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(userLoginDTO.getPassword(), user.getPassword())) {
            return new UserResponseDTO(user.getId(), user.getUsername());
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(u -> new UserResponseDTO(u.getId(), u.getUsername()))
                .toList();
    }

    public Optional<UserResponseDTO> getUserById(Long id) {
        return userRepository.findById(id)
                .map(u -> new UserResponseDTO(u.getId(), u.getUsername()));
    }

    public UserResponseDTO updateUser(Long id, UserCreateDTO userCreateDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userCreateDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
        User updatedUser = userRepository.save(user);
        return new UserResponseDTO(updatedUser.getId(), updatedUser.getUsername());
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
