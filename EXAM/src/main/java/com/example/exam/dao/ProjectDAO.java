package com.example.exam.dao;

import com.example.exam.model.Project;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ProjectDAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("defaultdb");

    public static List<Project> getAllProjects() {
        EntityManager em = emf.createEntityManager();
        List<Project> projects = em.createQuery("SELECT p FROM Project p", Project.class).getResultList();
        em.close();
        return projects;
    }

    public static Project getProjectById(Long id) {
        EntityManager em = emf.createEntityManager();
        Project project = em.find(Project.class, id);
        em.close();
        return project;
    }

    public static void createProject(Project project) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(project);
        em.getTransaction().commit();
        em.close();
    }

    public static void updateProject(Project project) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(project);
        em.getTransaction().commit();
        em.close();
    }

    public static void deleteProject(Project project) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(project));
        em.getTransaction().commit();
        em.close();
    }
}
