
package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * Crea un programa que pida al usuario que ingrese su nombre y lo escriba en un
 * fichero binario llamado nombre.bin. Asegúrate de que el fichero se
 * sobrescriba si ya existe.
 */
public class Ejer1_EscribirNombre {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Path path = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\nombre.bin");

        System.out.println("Introduce el nombre: ");
        String nombre = sc.nextLine();
        byte[] datosNombre = nombre.getBytes();
        sc.close();

        try {
            // Escribir los datos en el fichero binario
            Files.write(path, datosNombre);
            System.out.println("Datos escritos correctamente en " + path.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
