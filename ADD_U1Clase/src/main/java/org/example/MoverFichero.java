package org.example;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class MoverFichero {
    public static void main(String[] args) {
        Path origen = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficherosCopia\\ficherosCopiado.txt"); // Reemplaza con tu ruta
        Path destino = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheroMovido.txt");

        try {
            // Mover el fichero
            Files.move(origen, destino);
            System.out.println("Fichero movido correctamente a " + destino.toString());
        } catch (IOException e) {
            System.out.println("Ocurrió un error al mover el fichero.");
            e.printStackTrace();
        }
    }
}
