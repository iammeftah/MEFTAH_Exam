package com.example.exam.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ElementCollection
    private List<String> skills;

    @Enumerated(EnumType.STRING)
    private Post post;

    @OneToMany(mappedBy = "employee")
    private List<Affection> affections;

    public Employee() {
    }

    public Employee(String name, String email, List<String> skills, Post post) {
        this.name = name;
        this.email = email;
        this.skills = skills;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Affection> getAffections() {
        return affections;
    }

    public void setAffections(List<Affection> affections) {
        this.affections = affections;
    }
}