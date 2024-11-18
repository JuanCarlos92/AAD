package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejer1_EscribirNombre2 {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\nombre.bin");
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce tu nombre: ");
        byte[] nombre = sc.nextLine().getBytes();
        sc.close();

        try {
            Files.write(path,nombre);
            System.out.println("Datos ingresados correctamente en la ruta " + path.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
