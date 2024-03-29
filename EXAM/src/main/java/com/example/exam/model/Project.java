package com.example.exam.model;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double budget;

    @OneToMany(mappedBy = "project")
    private List<Affection> affections;

    public Project() {
    }

    public Project(String name, double budget) {
        this.name = name;
        this.budget = budget;
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

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public List<Affection> getAffections() {
        return affections;
    }

    public void setAffections(List<Affection> affections) {
        this.affections = affections;
    }
}