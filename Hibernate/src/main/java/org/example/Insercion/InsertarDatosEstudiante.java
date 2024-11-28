package org.example.Insercion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertarDatosEstudiante {
    public static void main(String[] args) {
        // Paso 1: Configurar la SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Estudiante.class)
                .buildSessionFactory();

        // Paso 2: Obtener una sesión
        Session session = factory.getCurrentSession();

        try {
            // Paso 3: Crear un objeto Persona
            Estudiante nuevoEstudiante1 = new Estudiante("Ana", "García", "ana.garcia@example.com",20);
            Estudiante nuevoEstudiante2 = new Estudiante ("Luis","Martínez","luis.martinez@example.com", 22);
            Estudiante nuevoEstudiante3 = new Estudiante ("Pedro","Sánchez","pedro.sanchez@example.com", 21);

            // Paso 4: Iniciar una transacción
            session.beginTransaction();

            // Paso 5: Guardar el objeto en la base de datos
            session.save(nuevoEstudiante1);
            session.save(nuevoEstudiante2);
            session.save(nuevoEstudiante3);

            // Paso 6: Confirmar la transacción
            session.getTransaction().commit();

            System.out.println("Persona guardada con éxito: " + nuevoEstudiante1);
            System.out.println("Persona guardada con éxito: " + nuevoEstudiante2);
            System.out.println("Persona guardada con éxito: " + nuevoEstudiante3);

        } finally {
            factory.close();
        }
    }
}
