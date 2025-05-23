package com.example.flappy.model;

import jakarta.persistence.*;

@Entity// Marks this class as a JPA entity (will map to a table in DB)
public class User {
    @Id // Primary key for this entity
    @GeneratedValue( strategy = GenerationType.IDENTITY)// Auto-increment ID in DB
    private Long id;

    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
