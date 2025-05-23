package com.example.flappy.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Comment {
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    private String content;
    private LocalDateTime createdAt;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;

    public Comment() {
    }

    public Comment(String content) {
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
    public LocalDateTime getCreatedDate() {
        return createdAt;
    }

    public Post getPost() {
        return post;
    }
    public User getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdAt = createdDate;
    }

    public void setPost(Post post) {
        this.post = post;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
