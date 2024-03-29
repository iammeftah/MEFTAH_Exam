package com.example.exam.controller;


import com.example.exam.dao.*;
import com.example.exam.model.*;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;

import java.util.Date;
import java.util.List;

@ManagedBean
@ViewScoped
public class AffectionController {
    private Employee employee;
    private Project project;
    private int implicationPercentage;

    public void affectProjectToEmployee() {
        Affection affection = new Affection();
        affection.setEmployee(employee);
        affection.setProject(project);
        affection.setPrimaryResource(implicationPercentage >= 50);
        affection.setStartDate(new Date());

        AffectionDAO.createAffection(affection);
    }

    public List<Employee> getEmployees() {
        return EmployeeDAO.getAllEmployees();
    }

    public List<Project> getProjects() {
        return ProjectDAO.getAllProjects();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getImplicationPercentage() {
        return implicationPercentage;
    }

    public void setImplicationPercentage(int implicationPercentage) {
        this.implicationPercentage = implicationPercentage;
    }
    public String affectProject() {
        return "affection.xhtml";     }

    public String goHome() {
        return "home.xhtml";
    }
}