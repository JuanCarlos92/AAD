/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author JuanCarlos
 */
public class EjemploCopiarYLeerFichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Path sourcePath = Paths.get("C:\\Users\\juanc\\Documents\\ejemploCopiar.txt");
        Path destinationPath = Paths.get("destino.txt");
        try {
            // Copiar un fichero
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            System.out.println("Error encontrado: " + e.getMessage());
        }
    }
    
}
