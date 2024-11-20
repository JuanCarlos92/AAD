package org.example;

import java.sql.*;

public class ConexionBD {
    private Connection conexion;
    private static final String URL = "jdbc:mysql://localhost/productos_categorias";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    //Metodo para conectar con la BD
    public Connection conectar() throws SQLException {
        //Devuelve la conexión (url, usuario, pwd)
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}




