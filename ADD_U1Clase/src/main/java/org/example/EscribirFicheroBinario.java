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
public class EscribirFicheroBinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\juanc\\Documents\\ejemplobinario.bin");

        byte[] datos = {65, 66, 67, 68, 69};// Datos en formato binario (A, B, C, D, E)

        try {
            // Escribir los datos en el fichero binario
            Files.write(path, datos);
            System.out.println("Datos escritos correctamente en " + path.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
