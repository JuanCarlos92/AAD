package org.example.Consultar;

import org.example.dto.Estudiante;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ConsultarEstudianteMasJoven {
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

            // Ejecutar una consulta HQL para obtener el número de Estudiantes
            List<Estudiante> estudiantes = session.createQuery("from Estudiante order by edad", Estudiante.class)
                    .getResultList();

            Estudiante estudiante = estudiantes.getFirst(); // Obtener el primer estudiante
            System.out.println(estudiante);

            // Confirmar la transacción
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            factory.close(); // Cerrar la fábrica de sesiones
        }
    }
}