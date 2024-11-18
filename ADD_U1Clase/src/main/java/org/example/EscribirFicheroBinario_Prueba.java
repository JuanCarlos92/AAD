/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.example;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author JuanCarlos
 */
public class EscribirFicheroBinario_Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombre = "Juan Carlos Filter Martin";

        String ruta = "C:\\Users\\juanc\\Documents\\nombre.bin";
        try {
            // Crear el archivo con el nombre en binario
            FileWriter fichero = new FileWriter(ruta);

            // Escribir el texto en binario dentro del archivo
            fichero.write(convertirABinario(nombre) + "\n");

            // Cerrar el archivo
            fichero.close();

            System.out.println("Archivo guardado");

        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar el archivo.");
            e.printStackTrace();
        }
    }

    public static String convertirABinario(String nombre) {

        StringBuilder binario = new StringBuilder();

        for (char c : nombre.toCharArray()) {

            // Convierte el valor ASCII del carácter a binario
            String bin = Integer.toBinaryString(c);

            binario.append(bin).append(" ");
        }

        return binario.toString();
    }

}
