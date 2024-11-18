package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LeerFicheroTexto {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\fichero.txt"); // Reemplaza con tu ruta

        try {
            // Leer todas las líneas del fichero
            List<String> lineas = Files.readAllLines(path);
            // Files.readString(path); para una sola línea
            lineas.forEach(System.out::println); // Imprimir cada línea
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el fichero.");
            e.printStackTrace();
        }
    }
}
