package com.example.exam.controller;

import com.example.exam.dao.*;
import com.example.exam.model.*;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;

import java.util.List;

@ManagedBean
@ViewScoped
public class ProjectController {
    private List<Project> projects;

    public ProjectController() {
        this.projects = ProjectDAO.getAllProjects();
    }

    public List<Project> getProjects() {
        return projects;
    }

}
