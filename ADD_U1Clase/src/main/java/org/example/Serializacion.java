/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author JuanCarlos
 */
public class Serializacion {
    public static void main(String[] args) {
        // Serialización
        Persona persona = new Persona("JuanCarlos", 32);
        try (FileOutputStream fileOut = new FileOutputStream("persona.bin"); ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(persona);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
