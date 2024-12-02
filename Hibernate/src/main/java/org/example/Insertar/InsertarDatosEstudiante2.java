package org.example.Insertar;

import org.example.dto.Estudiante;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertarDatosEstudiante2 {
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
            Estudiante nuevoEstudiante = new Estudiante("Carlos", "Lopez", "carlos.lopez@example.com",20);

            // Paso 4: Iniciar una transacción
            session.beginTransaction();

            // Paso 5: Guardar el objeto en la base de datos
            session.save(nuevoEstudiante);


            // Paso 6: Confirmar la transacción
            session.getTransaction().commit();

            System.out.println("Persona guardada con éxito: " + nuevoEstudiante);
            System.out.println("Nº de ID generado " + nuevoEstudiante.getId());


        } finally {
            factory.close();
        }
    }
}