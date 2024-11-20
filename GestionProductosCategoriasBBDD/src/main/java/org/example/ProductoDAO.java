package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDAO {
    private Connection conexion;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ProductoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void insertarProducto(Producto producto){
        String sql = "INSERT INTO Producto (nombre, precio, categoria_id) VALUES (?, ?, ?)";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getcategoriaId());
            ps.executeUpdate();
            System.out.println("Producto insertado exitosamente.");
        }catch (SQLException e) {
            System.out.println("Error al insertar producto." + e.getMessage());
        }finally {
            DesconexionBD.cerrarResultSet(rs);
            DesconexionBD.cerrarPreparedStatement(ps);
            DesconexionBD.desconectar(conexion);
        }
    }
}