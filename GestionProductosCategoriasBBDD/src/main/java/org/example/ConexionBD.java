package org.example;

import java.sql.*;

public class ConexionBD {
    private Connection conexion;
    private static final String URL = "jdbc:mysql://localhost/productosbd";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    ConexionBD() {}

    //Metodo para conectar con la BD
    public static Connection getConexion() throws SQLException, ClassNotFoundException {
        // Cargar el driver de MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Devuelve la conexión (url, usuario, pwd)
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}




