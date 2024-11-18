package org.example;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejer4_LeerObjetoPersona1 {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\persona.bin");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path.toString()))) {

            //Deserializar objeto persona
            Persona persona = (Persona) in.readObject();
            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Edad: " + persona.getEdad());
            System.out.println("Direccion: " + persona.getDireccion());

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
