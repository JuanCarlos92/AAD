package org.example.dao;

import org.example.dto.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductoDAO {
    private Connection conexion;
    private PreparedStatement ps = null;

    public ProductoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Inserta un nuevo producto
    public void insertarProducto(Producto producto) {
        String sql = "INSERT INTO Producto (nombre, precio, categoria_id) VALUES (?, ?, ?)";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getCategoriaId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar producto: " + e.getMessage());
        } finally {
            cerrarRecursos();
        }
    }

    // Método auxiliar para cerrar recursos
    private void cerrarRecursos() {
        try {
            if (ps != null && !ps.isClosed()) ps.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar recursos: " + e.getMessage());
        }
    }
}