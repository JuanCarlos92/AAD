package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*
Escribe un programa que lea el fichero lineas.txt y cuente cuántas líneas tiene, imprimiendo el resultado en la consola.
 */
public class Ejer4_ContarLineas {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\mensaje.txt");

        try {
            //Leer todas las líneas del fichero
            List<String> lineas = Files.readAllLines(path);

            System.out.println("El contenido del mensaje.txt es el siguiente:");

            //Inprimir cada linea:
            lineas.forEach(System.out::println);

            //Imprime numero de lines:
            System.out.println("Tiene " + lineas.size() + " linea/s");
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
