package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class EscribirFicheroTexto {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\fichero.txt"); // Reemplaza con tu ruta

        try {
            // Escribir texto en el fichero
            Files.write(path, Arrays.asList("Línea 1", "Línea 2", "Línea 3"));
            // Para una sola línea
            // Files.writeString(path, "Hola Mundo");
            System.out.println("Texto escrito correctamente en " + path.toString());
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el fichero.");
            e.printStackTrace();
        }
    }
}
