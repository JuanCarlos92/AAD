/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.example;

import java.nio.file.Paths;

/**
 *
 * @author JuanCarlos
 */
public class EjemploPath {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Definir una ruta de ejemplo (relativa)
        String path = "documentos/ejemplo.txt";

        // Obtener el nombre del fichero
        System.out.println("Nombre del fichero: " + Paths.get(path).getFileName());

        // Obtener la ruta del directorio que contiene el fichero
        System.out.println("Directorio padre: " + (Paths.get(path).getParent() != null ?  Paths.get(path).getParent() : "N/A"));
       
        // Obtener la ruta absoluta
        System.out.println("Ruta absoluta: " + Paths.get("path").toAbsolutePath());
    }
    
}
