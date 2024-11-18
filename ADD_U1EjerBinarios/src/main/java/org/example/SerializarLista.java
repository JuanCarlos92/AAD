/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author JuanCarlos
 */
public class SerializarLista {

    public static void serializarPersona(List<Persona> listaPer) {
        //dentro del try para cerrar el flujo automaticamente...:

        //Escribimos el archivo binario personas.bin con FileOutputStream y a su vez ...
        //convertimos los datos leidos en un objeto para poder escribirlo y serializarlos

        try (ObjectOutputStream out = new ObjectOutputStream
                (new FileOutputStream("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\personas.bin"))) {

            out.writeObject(listaPer);
            System.out.println("Lista de personas serializada en el arhcivo");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
