package org.example;
/*
 * Crea un programa que pida al usuario que ingrese un mensaje y lo escriba en un fichero de texto llamado mensaje.txt.
 * Asegúrate de que el fichero se sobrescriba si ya existe.
 * */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejer1_EscribirMensaje {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Path path = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\mensaje.txt");

        System.out.print("Introduce el mensaje: ");
        String mensaje = sc.nextLine();
        sc.close();
        try {
            Files.writeString(path, mensaje);
            System.out.println("Mensaje escrito.");

        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero");
            e.printStackTrace();
        }
    }
}
