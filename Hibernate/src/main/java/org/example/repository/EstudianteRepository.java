package org.example.repository;

import org.example.dto.Empresa;
import org.example.dto.Estudiante;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

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

    public void actualizarEstudiantePorId(int id, Estudiante estudiante) {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            estudiante.setId(id);
            session.update(estudiante);

            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public List<Estudiante> obtenerEstudiantesConEdadMayorA(int edad) {
        Session session = factory.getCurrentSession();
        List<Estudiante> estudiantes;
        try {
            session.beginTransaction();
            estudiantes = session.createQuery("FROM Estudiante e WHERE e.edad > :edad", Estudiante.class)
                    .setParameter("edad", edad).getResultList();

            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return estudiantes;
    }
    public void agregarEmpresaConEstudiantes() {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            // Crear una empresa
            Empresa empresa = new Empresa("TechCorp");

            // Crear personas y agregarlas a la empresa
            Estudiante estudiante1 = new Estudiante("Juan","Filter","juan@gmail.com",20);
            Estudiante estudiante2 = new Estudiante("Manuel","Rull","manuel@gmail.com",22);
            Estudiante estudiante3 = new Estudiante("Andres","Martin","andres@gmail.com",18);

            empresa.addEstudiante(estudiante1);
            empresa.addEstudiante(estudiante2);
            empresa.addEstudiante(estudiante3);

            // Guardar la empresa y las personas (gracias al cascade)
            session.save(empresa);

            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public void cerrar() {
        factory.close();
    }
}

