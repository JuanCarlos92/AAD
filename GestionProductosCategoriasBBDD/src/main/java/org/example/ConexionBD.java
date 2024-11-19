package org.example;

import java.sql.*;

public class ConexionBD {
    private Connection conexion;
    private PreparedStatement prepareStatement;
    private ResultSet resultSet;

    //Metodo para conectar con la BD
    public Connection conectar() {
        try {
            //Decir que tipo de bbdd tengo
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Se crea la conexión (url, usuario, pwd)
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/productos_categorias", "user", "user");
            System.out.println("Conexión a MySQL establecida con éxito.");

        }catch (Exception e){
            System.out.println("Error al conectar con la BD " + e.getMessage());
        }

        return conexion;
    }

    //Metodo para desconectar con la BD
    public void desconectar(){
        try {
            //En caso de que Connection, preparedStatement o ResultSet no sea null se desconecta con la BD
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Desconexion con la BD.");
            }

        } catch (SQLException e) {
            System.out.println("Error al desconectar con la BD " + e.getMessage());
        }
    }

}




