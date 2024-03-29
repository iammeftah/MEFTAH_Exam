package com.example.exam.dao;

import com.example.exam.model.Affection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AffectionDAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("defaultdb");

    public static List<Affection> getAllAffections() {
        EntityManager em = emf.createEntityManager();
        List<Affection> affections = em.createQuery("SELECT a FROM Affection a", Affection.class).getResultList();
        em.close();
        return affections;
    }

    public static Affection getAffectionById(Long id) {
        EntityManager em = emf.createEntityManager();
        Affection affection = em.find(Affection.class, id);
        em.close();
        return affection;
    }

    public static void createAffection(Affection affection) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(affection);
        em.getTransaction().commit();
        em.close();
    }

    public static void updateAffection(Affection affection) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(affection);
        em.getTransaction().commit();
        em.close();
    }

    public static void deleteAffection(Affection affection) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(affection));
        em.getTransaction().commit();
        em.close();
    }
}
