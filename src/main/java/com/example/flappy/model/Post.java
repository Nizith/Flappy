package com.example.flappy.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private LocalDateTime createdAt;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likes = new ArrayList<>();

    public Post() {
    }

    public Post(String title, String content) {
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }
    public Long getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
    public LocalDateTime getCreatedDate() {
        return createdAt;
    }
    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdAt = createdDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
