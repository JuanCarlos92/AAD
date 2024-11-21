package org.example.dao;
import org.example.DesconexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoCategoriaDAO {

    private Connection conexion;

    public ProductoCategoriaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    //Metodo para obtener productos con sus categorías
    private void obtenerProductos(String sql) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = conexion.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Obtener los valores de cada columna
                int productoId = resultSet.getInt("producto_id");
                String productoNombre = resultSet.getString("producto_nombre");
                double precio = resultSet.getDouble("precio");
                int categoriaId = resultSet.getInt("categoria_id");
                String categoriaNombre = resultSet.getString("categoria_nombre");

                // Mostrar el producto y su categoría
                System.out.println("Producto ID: " + productoId + ", Nombre: " + productoNombre +
                        ", Precio: " + precio + ", Categoría ID: " + categoriaId +
                        ", Categoría: " + categoriaNombre);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los productos con categorías: " + e.getMessage());
        } finally {
            // Cerrar recursos
            DesconexionBD.cerrarResultSet(resultSet);
            DesconexionBD.cerrarPreparedStatement(preparedStatement);
        }
    }

    // obtener productos con categorías
    public void obtenerProductosConCategorias() {
        String sql = "SELECT p.id AS producto_id, p.nombre AS producto_nombre, p.precio, " +
                "c.id AS categoria_id, c.nombre AS categoria_nombre " +
                "FROM Producto p " +
                "JOIN Categoria c ON p.categoria_id = c.id";

        obtenerProductos(sql); // Llamada al metodo común
    }

    // obtener productos con categorías precio > 100
    public void obtenerProductosConCategoriasPrecioMayorA100() {
        String sql = "SELECT p.id AS producto_id, p.nombre AS producto_nombre, p.precio, " +
                "c.id AS categoria_id, c.nombre AS categoria_nombre " +
                "FROM Producto p " +
                "JOIN Categoria c ON p.categoria_id = c.id " +
                "WHERE p.precio > 100";

        obtenerProductos(sql); // Llamada al metodo común
    }
}

