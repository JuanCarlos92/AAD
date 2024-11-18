package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Ejer5_ListadePersonas1 {
    private static List<Persona> personas;

    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
                "C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\personas.bin"))) {

            personas.add(new Persona("Juan", 25, "Calle de la luna 23"));
            personas.add(new Persona("Mario", 80, "Avenida Siempre Viva 2"));
            personas.add(new Persona("Oscar", 28, "Calle del Sol 6"));

            out.writeObject(personas);
            System.out.println("La lista de personas está serializada en el archivo");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
