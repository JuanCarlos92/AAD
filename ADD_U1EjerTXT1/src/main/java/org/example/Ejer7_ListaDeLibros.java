package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejer7_ListaDeLibros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String respuesta = "si";
        Path path = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\libros.txt");

        try {
            FileWriter fw = new FileWriter(path.toFile(), true);

            while (respuesta.equalsIgnoreCase("si")) {
                System.out.println("Titulo del libro:");
                String titulo = sc.nextLine();

                System.out.println("Autor del libro:");
                String autor = sc.nextLine();

                fw.write("Titulo: " + titulo + ", Autor: " +autor + "\n");

                System.out.print("Quieres agregar otro libro? (si/no): ");
                respuesta = sc.nextLine();
            }
            fw.close();
            sc.close();

            System.out.println("Los libros se han guardado correctamente");


        }catch (IOException e){
            e.printStackTrace();
        }




    }
}
