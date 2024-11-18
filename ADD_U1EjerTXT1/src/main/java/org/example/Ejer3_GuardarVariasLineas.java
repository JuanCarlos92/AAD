package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

/*
Crea un programa que pida al usuario que ingrese tres líneas de texto y las escriba en un fichero de texto
llamado lineas.txt, asegurándote de que cada línea se guarde en una línea separada del fichero.
 */
public class Ejer3_GuardarVariasLineas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Path path = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\lineas.txt");
        System.out.print("Introduce la primera linea:");
        String linea1 = sc.nextLine();
        System.out.print("Introduce la segunda linea:");
        String linea2 = sc.nextLine();
        System.out.print("Introduce la tercera linea:");
        String linea3 = sc.nextLine();
        sc.close();
        try {
            //Escribir texto en el fichero
            Files.write(path, Arrays.asList(linea1, linea2, linea3));

            System.out.println("El textos e ha escrito corretamente en el fichero");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
