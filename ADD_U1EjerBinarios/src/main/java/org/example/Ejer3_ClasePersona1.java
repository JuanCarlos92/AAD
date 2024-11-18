package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejer3_ClasePersona1 {
    public static void main(String[] args) throws IOException {
        Persona persona = new Persona("JuanCarlos", 32,"CalleLarga");
        Path path = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\persona.bin");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(String.valueOf(path)))) {
            oos.writeObject(persona);
            System.out.println("El objeto de la clase '" + persona + "' se ha serializado en el fichero");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
