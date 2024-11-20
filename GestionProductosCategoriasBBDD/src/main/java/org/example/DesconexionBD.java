package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DesconexionBD {


     //Metodo para cerrar la conexión
    public static void desconectar(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    //Metodo para cerrar un Statement.
    public static void cerrarStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
                System.out.println("Statement cerrado correctamente.");
            } catch (Exception e) {
                System.out.println("Error al cerrar el Statement: " + e.getMessage());
            }
        }
    }

    //Metodo para cerrar PreparedStatement.
    public static void cerrarPreparedStatement(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
                System.out.println("PreparedStatement cerrado correctamente.");
            } catch (Exception e) {
                System.out.println("Error al cerrar el PreparedStatement: " + e.getMessage());
            }
        }
    }

    //Metodo para cerrar un ResultSet.
    public static void cerrarResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
                System.out.println("ResultSet cerrado correctamente.");
            } catch (Exception e) {
                System.out.println("Error al cerrar el ResultSet: " + e.getMessage());
            }
        }
    }

}