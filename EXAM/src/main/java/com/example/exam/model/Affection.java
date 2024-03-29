package com.example.exam.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Affection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private boolean primaryResource;
    private Date startDate;
    private Date endDate;

    public Affection() {
    }

    public Affection(Project project, Employee employee, boolean primaryResource, Date startDate, Date endDate) {
        this.project = project;
        this.employee = employee;
        this.primaryResource = primaryResource;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isPrimaryResource() {
        return primaryResource;
    }

    public void setPrimaryResource(boolean primaryResource) {
        this.primaryResource = primaryResource;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}