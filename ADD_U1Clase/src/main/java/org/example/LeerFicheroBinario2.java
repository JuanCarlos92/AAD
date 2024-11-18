/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.example;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author JuanCarlos
 */
public class LeerFicheroBinario2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ruta = "C:\\Users\\juanc\\Documents\\nombre.bin";

        try {
            FileInputStream fichero = new FileInputStream(ruta);
            StringBuilder contenidoTexto = new StringBuilder();
            int byteLeido;

            // Leer el archivo byte a byte
            while ((byteLeido = fichero.read()) != -1) {
                // Convertir el byte leído a hexadecimal y añadirlo a la cadena
                contenidoTexto.append((char) byteLeido);
            }

            fichero.close();  // Cerrar el archivo después de leerlo

            // Mostrar el contenido en hexadecimal por consola
            System.out.println("Contenido del archivo:");
            System.out.println(contenidoTexto.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
