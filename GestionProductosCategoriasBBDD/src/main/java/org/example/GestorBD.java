package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorBD {
    private Connection conexion;
    private Statement statement;
    private PreparedStatement prepareStatement;



    public void crearTablas(){
        String tablaCategoria = "CREATE TABLE IF NOT EXISTS Categoria (" +
                "id INT PRIMARY KEY, " +
                "nombre VARCHAR(50) NOT NULL" +
                ")";

        String tablaProducto = "CREATE TABLE IF NOT EXISTS Producto (" +
                "id INT PRIMARY KEY, " +
                "nombre VARCHAR(100) NOT NULL, " +
                "precio DECIMAL(10, 2) NOT NULL, " +
                "categoria_id INT, FOREIGN KEY (categoria_id) REFERENCES Categoria(id)" +
                ")";
        try {
             conexion = new ConexionBD().conectar();
             statement = conexion.createStatement();
             statement.execute(tablaCategoria);
             statement.execute(tablaProducto);
             System.out.println("Tablas creadas exitosamente.");


        }catch (Exception e){
            System.out.println("Error al crear las tablas" + e.getMessage());
        }
    }
    public void insertarEnCategoria(Categoria categoria) {
        String sql = "INSERT INTO Categoria (nombre) VALUES (?)";
        try {
            conexion = new ConexionBD().conectar();
            prepareStatement  = conexion.prepareStatement(sql);
            prepareStatement.setString(1, categoria.getNombre());
            prepareStatement.executeUpdate();

            System.out.println("Categoría insertada exitosamente.");

        } catch (SQLException e) {
            System.out.println("Error al insertar categoría: " + e.getMessage());
        }
    }
    public void insertarEnProducto(Producto producto) {
        String sql = "INSERT INTO Producto (nombre) VALUES (?)";
        try {
            conexion = new ConexionBD().conectar();
            prepareStatement  = conexion.prepareStatement(sql);
            prepareStatement.setString(1, producto.getNombre());
            prepareStatement.executeUpdate();

            System.out.println("Categoría insertada exitosamente.");

        } catch (SQLException e) {
            System.out.println("Error al insertar categoría: " + e.getMessage());
        }
    }

}
