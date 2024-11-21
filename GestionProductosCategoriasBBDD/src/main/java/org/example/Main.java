package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Crear instancia de GestorBD
        GestorBD gestorBD = new GestorBD();

        //Llamar a los métodos según sea necesario
        gestorBD.crearTablas();
        gestorBD.insertarCategoria();
        gestorBD.insertarProducto();

        //Cerrar la conexión
        gestorBD.cerrarConexion();

    }
}