package org.example.dao;

import org.example.dto.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private Connection conexion;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public CategoriaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Verifica si una categoría existe por su nombre
    public boolean existeCategoria(String nombre) {
        String sql = "SELECT COUNT(*) FROM Categoria WHERE nombre = ?";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.out.println("Error al verificar si existe la categoría: " + e.getMessage());
        } finally {
            cerrarRecursos();
        }
        return false;
    }

    // Inserta una nueva categoría
    public void insertarCategoria(Categoria categoria) {
        String sql = "INSERT INTO Categoria (nombre) VALUES (?)";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, categoria.getNombre());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar categoría: " + e.getMessage());
        } finally {
            cerrarRecursos();
        }
    }

    // Obtiene todas las categorías
    public List<Categoria> obtenerCategorias() {
        String sql = "SELECT id, nombre FROM Categoria";
        List<Categoria> categorias = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                categorias.add(new Categoria(rs.getInt("id"), rs.getString("nombre")));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener categorías: " + e.getMessage());
        } finally {
            cerrarRecursos(stmt, rs);
        }
        return categorias;
    }

    // Método auxiliar para cerrar recursos
    private void cerrarRecursos() {
        try {
            if (rs != null && !rs.isClosed()) rs.close();
            if (ps != null && !ps.isClosed()) ps.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar recursos: " + e.getMessage());
        }
    }

    // Sobrecarga para cerrar Statement y ResultSet
    private void cerrarRecursos(Statement stmt, ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) rs.close();
            if (stmt != null && !stmt.isClosed()) stmt.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar recursos: " + e.getMessage());
        }
    }
}
