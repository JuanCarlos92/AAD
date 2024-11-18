package org.example;

import java.io.*;
import java.util.Scanner;

public class Ejer9_ModificarUnObjeto1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Deserializar
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\persona.bin"))) {

            Persona persona = (Persona) in.readObject();

            //Pedir datos:
            System.out.print("Introduce la nueva edad: ");
            int edad = sc.nextInt();
            persona.setEdad(edad);

            //Serializar
            try (ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\persona.bin"))) {

                out.writeObject(persona);
                System.out.println("Edad Actualizada");
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
