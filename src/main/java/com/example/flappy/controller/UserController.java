package com.example.flappy.controller;

import com.example.flappy.dto.UserCreateDTO;
import com.example.flappy.dto.UserLoginDTO;
import com.example.flappy.dto.UserResponseDTO;
import com.example.flappy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserResponseDTO createUser(@RequestBody UserCreateDTO userCreateDTO) {
        UserResponseDTO user = userService.register(userCreateDTO);
        user.setMessage("User registered successfully");
        return user;
    }

    @PostMapping("/login")
    public UserResponseDTO loginUser(@RequestBody UserLoginDTO userLoginDTO) {
        UserResponseDTO user = userService.login(userLoginDTO);
        user.setMessage("User Logged in successfully");
        return user;
    }

    @GetMapping("/get-all-users")
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get-user/{id}")
    public UserResponseDTO getUser(@PathVariable Long id) {
        return userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PutMapping("/edit-user/{id}")
    public UserResponseDTO updateUser(@PathVariable Long id, @RequestBody UserCreateDTO userCreateDTO) {
        return userService.updateUser(id, userCreateDTO);
    }

    @DeleteMapping("/delete-user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
