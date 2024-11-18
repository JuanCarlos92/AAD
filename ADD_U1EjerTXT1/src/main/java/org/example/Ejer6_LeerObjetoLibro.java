package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
Escribe un programa que lea el fichero libro.txt y muestre los atributos del objeto Libro en la consola,
separando el título y el autor.
 */
public class Ejer6_LeerObjetoLibro {
    public static void main(String[] args) {
        // Leer el archivo libro.txt
        try (BufferedReader bfr = new BufferedReader(new FileReader("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\libro.txt"))){
            String linea = bfr.readLine();//Lee la linea

            //Crear objeto Libro con el metodo
            Libro lib = Libro.obtenerLibro(linea);

            //Muestra el libro:
            System.out.println("Título: " + lib.getTitulo());
            System.out.println("Autor: " + lib.getAutor());

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
