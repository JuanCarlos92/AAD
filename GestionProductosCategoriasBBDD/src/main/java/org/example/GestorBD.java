package org.example;

import org.example.dao.CategoriaDAO;
import org.example.dao.ProductoDAO;
import org.example.dto.Categoria;
import org.example.dto.Producto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class GestorBD {
    private Connection conexion;

    public GestorBD() {
        try {
            // Crear la conexión
            this.conexion = ConexionBD.getConexion();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error al establecer la conexión: " + e.getMessage());
        }
    }

    // Metodo para crear las tablas en la base de datos
    public void crearTablas() {
        String tableCategoria = "CREATE TABLE IF NOT EXISTS Categoria (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nombre VARCHAR(50) NOT NULL UNIQUE" +
                ")";

        String tableProducto = "CREATE TABLE IF NOT EXISTS Producto (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nombre VARCHAR(100) NOT NULL, " +
                "precio DECIMAL(10, 2) NOT NULL, " +
                "categoria_id INT, " +
                "FOREIGN KEY (categoria_id) REFERENCES Categoria(id)" +
                ")";

        Statement statement = null;

        try {
            statement = conexion.createStatement();

            statement.execute(tableCategoria);
            statement.execute(tableProducto);

            System.out.println("Tablas creadas correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear las tablas: " + e.getMessage());
        }finally {
            DesconexionBD.cerrarStatement(statement);
        }
    }

    // Metodo para insertar una nueva categoría
    public void insertarCategoria() {
            try {
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
            }catch (Exception e){
                System.out.println("Error al insertar la categoria en la bd" + e.getMessage());
            }
    }

    // Metodo para insertar un nuevo producto
    public void insertarProducto() {
        try {

            ProductoDAO productoDAO = new ProductoDAO(conexion);
            CategoriaDAO categoriaDAO = new CategoriaDAO(conexion);
            Scanner sc = new Scanner(System.in);

            System.out.print("Introduce el nombre del producto: ");
            String nombreProducto = sc.nextLine();

            System.out.print("Introduce el precio del producto: ");
            double precioProducto = sc.nextDouble();

            // Limpiar el buffer del Scanner
            sc.nextLine();

            List<Categoria> categorias = categoriaDAO.obtenerCategorias();
            if (categorias.isEmpty()) {
                System.out.println("No hay categorías disponibles. Por favor, inserta una categoría primero.");
                return;
            }

            System.out.println("Categorías disponibles:");
            categorias.forEach(c -> System.out.printf("ID: %d, Nombre: %s%n", c.getId(), c.getNombre()));

            System.out.print("Introduce el ID de la categoría: ");
            int categoriaId = sc.nextInt();

            // Validar que la categoría existe
            boolean categoriaExiste = categorias.stream().anyMatch(c -> c.getId() == categoriaId);
            if (!categoriaExiste) {
                System.out.println("La categoría seleccionada no existe.");
                return;
            }

            productoDAO.insertarProducto(new Producto(nombreProducto, precioProducto, categoriaId));
            System.out.println("Producto insertado exitosamente.");

        } catch (Exception e) {
            System.out.println("Error al insertar producto: " + e.getMessage());
        }
    }

    //Metodo que llama a cesconexion desde la clase gestorBD
    public void cerrarConexion(){
        DesconexionBD.desconectar(conexion);
    }
}
