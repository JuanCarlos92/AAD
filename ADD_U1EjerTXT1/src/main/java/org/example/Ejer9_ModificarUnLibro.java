package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Ejer9_ModificarUnLibro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Path path = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\libros.txt");


        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {

            List<String> contarLineas = Files.readAllLines(path);
            int contador = contarLineas.size();

           // int libroLeido = Libro.obtenerLibro(contarLineas);

           // System.out.println("Titulo: " + libroLeido.getTitulo() + ", Autor: " + libroLeido.getAutor());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
