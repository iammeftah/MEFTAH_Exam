package com.example.exam.controller;

import com.example.exam.model.*;
import com.example.exam.dao.*;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;

import java.util.List;

@ManagedBean
@ViewScoped
public class EmployeeController {
    private List<Employee> employees;

    public EmployeeController() {
        this.employees = EmployeeDAO.getAllEmployees();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String removeEmployee(Employee employee) {
        EmployeeDAO.deleteEmployee(employee);
        employees.remove(employee);
        return null; // or specify the appropriate navigation outcome
    }

    public String affectProject() {
        return "affection";     }

    public String goHome() {
        return "home";
    }
}