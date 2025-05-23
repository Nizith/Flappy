package com.example.flappy.dto;

public class UserResponseDTO {
    private String message;
    private Long id;
    private String username;

    public UserResponseDTO() {}

    public UserResponseDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public UserResponseDTO(Long id, String username, String message) {
        this.id = id;
        this.username = username;
        this.message = message;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}