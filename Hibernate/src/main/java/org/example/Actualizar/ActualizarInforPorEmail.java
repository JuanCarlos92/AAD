package org.example.Actualizar;

import org.example.dto.Estudiante;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ActualizarInforPorEmail {
    public static void main(String[] args) {
        // Paso 1.1: Crear SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Estudiante.class)
                .buildSessionFactory();

        // Paso 1.2: Crear sesión
        Session session = factory.getCurrentSession();

        try {
            // Paso 1.3: Iniciar una transacción
            session.beginTransaction();

            // Ejecutar una consulta HQL con un parámetro
            String estudianteEmail = "juan.perez@example.com";
            List<Estudiante> estudiantes = session.createQuery("from Estudiante where email=:email", Estudiante.class)
                    .setParameter("email", estudianteEmail)
                    .getResultList();

            // Verificar si el estudiante fue encontrado
            if (!estudiantes.isEmpty()) {
                Estudiante estudiante = estudiantes.get(0); // Obtener el primer estudiante

                // Paso 3: Modificar el estudiante
                estudiante.setNombre("Manuel");  // Cambiar el nombre
                estudiante.setApellido("Martin");  // Cambiar el apellido
                estudiante.setEdad(25);  // Cambiar la edad

                // No es necesario usar session.update() porque Hibernate hace un seguimiento de los objetos modificados
            }

            // Paso 4: Confirmar la transacción
            session.getTransaction().commit();
            System.out.println("Estudiante actualizado con éxito.");

        } finally {
            // Paso 5: Cerrar la transacción
            factory.close();
        }
    }
}