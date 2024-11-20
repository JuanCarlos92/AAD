package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private Connection conexion;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Statement stmt = null;

    public CategoriaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean existeCategoria(String nombre) {
        String sql = "SELECT COUNT(*) FROM Categoria WHERE nombre = ?";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.out.println("Error al verificar si existe la categoria." + e.getMessage());

        } finally {
            DesconexionBD.cerrarResultSet(rs);
            DesconexionBD.cerrarPreparedStatement(ps);
            DesconexionBD.desconectar(conexion);
        }
        return false;
    }

    public void insertarCategoria(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO Categoria (nombre) VALUES (?)";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, categoria.getNombre());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar categoria." + e.getMessage());
        } finally {
            DesconexionBD.cerrarPreparedStatement(ps);
            DesconexionBD.desconectar(conexion);
        }
    }

    public List<Categoria> obtenerCategorias() {

        String sql = "SELECT id, nombre FROM Categoria";
        List<Categoria> categorias = new ArrayList<>();
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                categorias.add(new Categoria(rs.getInt("id"), rs.getString("nombre")));
            }
            return categorias;
        } catch (SQLException e) {
            System.out.println("Error al obtener categorias" + e.getMessage());

        } finally {
            DesconexionBD.cerrarResultSet(rs);
            DesconexionBD.desconectar(conexion);
            DesconexionBD.cerrarStatement(stmt);
        }
        return categorias;
    }
}
