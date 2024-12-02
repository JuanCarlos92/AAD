package org.example.Eliminar;

import org.example.dto.Estudiante;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminaUno {
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

            // Recuperar el estudiante con el id
            int estudianteId = 1;
            Estudiante estudiante = session.get(Estudiante.class, estudianteId);

            if (estudiante != null) {
                // Eliminar el estudiante
                session.delete(estudiante);
                System.out.println("Estudiante eliminado: " + estudiante);
            } else {
                System.out.println("El estudiante no existe con el id: " + estudianteId);
            }

            // Confirmar la transacción
            session.getTransaction().commit();
            System.out.println("La transacción fue confirmada.");
        } finally {
            factory.close();
        }
    }
}
