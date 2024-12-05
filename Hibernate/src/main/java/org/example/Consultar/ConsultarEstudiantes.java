package org.example.Consultar;
import org.example.dto.Estudiante;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ConsultarEstudiantes {
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
            List<Estudiante> estudiantes = session.createQuery("from Estudiante", Estudiante.class)
                    .getResultList();

            // Mostrar los resultados
            for (Estudiante estudiante : estudiantes) {
                System.out.println(estudiante);
            }

            // Confirmar la transacción
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            factory.close(); // Cerrar la fábrica de sesiones
        }
    }
}