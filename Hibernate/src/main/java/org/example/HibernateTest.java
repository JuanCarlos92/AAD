package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
    public static void main(String[] args) {
        // Cargar la configuración de Hibernate desde el archivo hibernate.cfg.xml
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Person.class).buildSessionFactory();

        // Obtener la sesión de Hibernate
        Session session = factory.getCurrentSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();

            // Crear un objeto para insertar en la base de datos
            Person tempPerson = new Person("John", "Doe", "john.doe@example.com");

            // Guardar el objeto en la base de datos
            session.save(tempPerson);

            // Hacer commit de la transacción
            session.getTransaction().commit();
            System.out.println("El registro se guardó exitosamente!");
        } finally {
            factory.close();
        }
    }
}