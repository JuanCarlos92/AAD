/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 *
 * @author JuanCarlos
 */
public class DeserializarLista {

    public static void deserializarPersona() throws ClassNotFoundException {
        //dentro del try para cerrar el flujo automaticamente...:
        //leemos el archivo binario personas.bin con fileinputStream y a su vez ...
        //convertimos los datos leidos en un objeto para poder leerlo y deserializarlos
        
        try (ObjectInputStream in = new ObjectInputStream
        (new FileInputStream("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\personas.bin"))) {

            List<Persona> listaPer = (List<Persona>) in.readObject();//Leer la lista de personas desde el archivo
            
            //Bucle para recorrer la lista
            for (Persona persona : listaPer) {
                System.out.println("Nombre " + persona.getNombre() + ", Edad: " +
                        persona.getEdad() + ", Direccion: " + persona.getDireccion() );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
