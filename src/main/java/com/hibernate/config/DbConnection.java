package com.hibernate.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DbConnection {

    private final static EntityManagerFactory em = Persistence.createEntityManagerFactory("peaksoft");

    public static EntityManager getEntityManager() {
        return em.createEntityManager();
    }
}