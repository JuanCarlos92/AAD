package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejer1_EscribirNombre1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del usuario: ");
        byte[] datos = sc.nextLine().getBytes();
        sc.close();
        Path path = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\nombre.bin");
        try {
            Files.write(path,datos);
            System.out.println("Nombre ingresado correctamente en " + path.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
