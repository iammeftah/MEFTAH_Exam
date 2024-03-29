package com.example.exam.dao;

import com.example.exam.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class EmployeeDAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("defaultdb");

    public static List<Employee> getAllEmployees() {
        EntityManager em = emf.createEntityManager();
        List<Employee> employees = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        em.close();
        return employees;
    }

    public static Employee getEmployeeById(Long id) {
        EntityManager em = emf.createEntityManager();
        Employee employee = em.find(Employee.class, id);
        em.close();
        return employee;
    }

    public static void createEmployee(Employee employee) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
        em.close();
    }

    public static void updateEmployee(Employee employee) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(employee);
        em.getTransaction().commit();
        em.close();
    }

    public static void deleteEmployee(Employee employee) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(employee));
        em.getTransaction().commit();
        em.close();
    }
}
