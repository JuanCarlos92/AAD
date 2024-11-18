/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Crea una clase Persona que contenga atributos como nombre, edad y dirección.
 * Serializa un objeto de la clase Persona en un fichero binario llamado
 * persona.bin.
 */
public class Ejer3_ClasePersona {

    public static void main(String[] args) {
       // Serialización
        Persona persona = new Persona("JuanCarlos", 32,"Calle Sin Nombre");
        try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\juanc\\Documents\\Datos\\persona.bin"); ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(persona);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}