package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopiarFichero {
    public static void main(String[] args) {
        Path origen = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\libro.txt"); // Reemplaza con tu ruta
        Path destino = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficherosCopia\\ficherosCopiado.txt");

        try {
            // Copiar el fichero
            Files.copy(origen, destino);
            System.out.println("Fichero copiado correctamente a " + destino.toString());
        } catch (IOException e) {
            System.out.println("Ocurrió un error al copiar el fichero.");
            e.printStackTrace();
        }
    }
}