/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author JuanCarlos
 */
public class LeerFicheroBinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\juanc\\Documents\\nombre.bin"); // Reemplaza con tu ruta

        try {
            // Leer todos los bytes del fichero
            byte[] datos = Files.readAllBytes(path);

            // Mostrar los datos en formato hexadecimal
            for (byte b : datos) {
                System.out.printf("%02X ", b);
            }
            System.out.println(); // Nueva línea al final

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el fichero.");
        }
    }

}
