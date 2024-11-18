/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author JuanCarlos
 */
public class ListarDirectorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {// Listar y imprimir los nombres de los ficheros en el directorio
            Files.list(Paths.get("C:\\Users\\juanc\\Documents")).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Se ha encontrado un error " + e.getMessage());
        }
    }

}
