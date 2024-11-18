/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//Escribe un programa que lea el contenido del fichero nombre.bin y lo imprima en la consola.

public class Ejer2_LeerNombre {

    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\juanc\\Documents\\archivosAccesoDatosEjerciciosU1\\nombreEjer.bin");

        try (InputStream inputStream = Files.newInputStream(path)) {
            int byteDato;
            System.out.println("Hexadecimal:");
            while ((byteDato = inputStream.read()) != -1) {
                System.out.printf("%02X ", byteDato); //hexadecimal
            }
            System.out.println();

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el fichero.");
            e.printStackTrace();
        }

    }
}