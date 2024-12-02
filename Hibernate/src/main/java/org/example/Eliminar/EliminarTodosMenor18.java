package org.example.Eliminar;

import org.example.dto.Estudiante;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EliminarTodosMenor18 {
    public static void main(String[] args) {
        // Crear la SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Estudiante.class)
                .buildSessionFactory();

        // Obtener la sesión
        Session session = factory.getCurrentSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();

            // Ejecutar una consulta HQL con ordenamiento y filtrado
            List<Estudiante> estudiantes = session.createQuery("from Estudiante where edad < 18", Estudiante.class)
                    .getResultList();

                for (Estudiante estudiante : estudiantes) {
                    // Eliminar los estudiantes
                    session.delete(estudiante);
                    System.out.println("Estudiante eliminado: " + estudiante);
                }

            // Confirmar la transacción
            session.getTransaction().commit();
            System.out.println("La transacción fue confirmada.");
        } finally {
            factory.close();
        }
    }
}