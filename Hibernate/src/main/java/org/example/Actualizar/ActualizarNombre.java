package org.example.Actualizar;
import org.example.dto.Estudiante;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ActualizarNombre {
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

            // Paso 2: Obtener el estudiante con el id
            int estudianteId = 1;
            Estudiante estudiante = session.get(Estudiante.class, estudianteId);

            // Verificar si el estudiante fue encontrado
            if (estudiante != null) {
                // Paso 3: Modificar el estudiante
                estudiante.setNombre("Carlos");  // Cambiar el nombre

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
