package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Ejer6_LeerListaPersonas1 {
    public static void main(String[] args) {
        try (ObjectInputStream in = new ObjectInputStream
                (new FileInputStream("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\personas.bin"))){

            //Deserializar el objeto a la lista
            List<Persona> personas = (List<Persona>) in.readObject();

            //Bucle recorrer la lista y mostramos lo que contiene
            for (Persona persona : personas) {
                System.out.println("Nombre: " + persona.getNombre()  + ", Edad: " +
                        persona.getEdad() + ", Direccion: " + persona.getDireccion());
            }

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
