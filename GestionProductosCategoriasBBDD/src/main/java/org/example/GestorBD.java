package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class GestorBD {
    private ConexionBD conexionBD = new ConexionBD();

    public void crearTablas() {
        String tableCategoria = "CREATE TABLE IF NOT EXISTS Categoria (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nombre VARCHAR(50) NOT NULL UNIQUE" +
                ")";

        String tableProducto = "CREATE TABLE IF NOT EXISTS Producto (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nombre VARCHAR(100) NOT NULL, " +
                "precio DECIMAL(10, 2) NOT NULL, " +
                "categoria_id INT, FOREIGN KEY (categoria_id) REFERENCES Categoria(id)" +
                ")";

        try (Connection conexion = conexionBD.conectar();
             Statement statement = conexion.createStatement()) {

            statement.execute(tableCategoria);
            statement.execute(tableProducto);
            System.out.println("Tablas creadas correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear las tablas: " + e.getMessage());
        }
    }

    public void insertarCategoria() {
        try (Connection conexion = conexionBD.conectar()) {

            CategoriaDAO categoriaDAO = new CategoriaDAO(conexion);
            Scanner sc = new Scanner(System.in);

            System.out.print("Introduce el nombre de la nueva categoría: ");
            String nombreCategoria = sc.nextLine();

            if (categoriaDAO.existeCategoria(nombreCategoria)) {
                System.out.println("La categoría ya existe en la base de datos.");
            } else {
                categoriaDAO.insertarCategoria(new Categoria(nombreCategoria));
                System.out.println("Categoría insertada exitosamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar categoría: " + e.getMessage());
        }
    }

    public void insertarProducto() {
        try (Connection conexion = conexionBD.conectar()) {

            ProductoDAO productoDAO = new ProductoDAO(conexion);
            CategoriaDAO categoriaDAO = new CategoriaDAO(conexion);
            Scanner sc = new Scanner(System.in);

            System.out.print("Introduce el nombre del producto: ");
            String nombreProducto = sc.nextLine();

            System.out.print("Introduce el precio del producto: ");
            double precioProducto = sc.nextDouble();

            List<Categoria> categorias = categoriaDAO.obtenerCategorias();
            System.out.println("Categorías disponibles:");
            categorias.forEach(c -> System.out.printf("ID:" + c.getId() + ", Nombre:" +  c.getNombre()));

            System.out.print("Introduce el ID de la categoría: ");
            int categoriaId = sc.nextInt();

            productoDAO.insertarProducto(new Producto(nombreProducto, precioProducto, categoriaId));
            System.out.println("Producto insertado exitosamente.");

        } catch (SQLException e) {
            System.out.println("Error al insertar producto: " + e.getMessage());
        }
    }
}