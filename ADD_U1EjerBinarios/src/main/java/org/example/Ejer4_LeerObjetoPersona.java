/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author JuanCarlos
 */
public class Ejer4_LeerObjetoPersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {

        //Leemos el archivo .bin y leemos ese objeto que está previamente serializado
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Users\\juanc\\Documents\\Datos\\persona.bin"))) {

            //Deserializar objeto persona
            Persona persona = (Persona) in.readObject();

            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Nombre: " + persona.getEdad());
            System.out.println("Nombre: " + persona.getDireccion());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
