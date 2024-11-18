package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/*
Crea una clase Libro que contenga atributos como título y autor. Escribe un programa que cree un objeto Libro y
lo guarde en un fichero de texto llamado libro.txt, utilizando el formato “Título: {titulo}, Autor: {autor}”.
 */
public class Ejer5_ClaseLibro {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\libro.txt");
        Libro libro = new Libro();

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el Título del libro: ");
        String titulo = sc.nextLine();
        System.out.print("Introduce el Autor del libro: ");
        String autor = sc.nextLine();
        sc.close();

        libro.setTitulo(titulo);
        libro.setAutor(autor);

        try {
            Files.writeString(path, libro.toString());
            System.out.println("Se ha guardado el siguiente libro: " + libro.toString());
        }catch (IOException e){
            e.printStackTrace();
        }



    }
}
