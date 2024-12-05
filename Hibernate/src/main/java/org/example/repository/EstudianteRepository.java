package org.example.repository;

import org.example.dto.Estudiante;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EstudianteRepository {
    private SessionFactory factory;

    public EstudianteRepository() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Estudiante.class)
                .buildSessionFactory();
    }

    public void guardarEstudiante(Estudiante estudiante) {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(estudiante);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
    public Estudiante obtenerPersonaPorId(int id) {
        Session session = factory.getCurrentSession();
        Estudiante estudiante = null;
        try {
            session.beginTransaction();
            estudiante = session.get(Estudiante.class, id);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return estudiante;
    }
    public void eliminarEstudiante(int id) {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Estudiante estudiante = session.get(Estudiante.class, id);
            if (estudiante != null) {
                session.delete(estudiante);
            }
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}

