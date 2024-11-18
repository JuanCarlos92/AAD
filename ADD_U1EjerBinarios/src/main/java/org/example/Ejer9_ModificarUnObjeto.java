package org.example;

import java.io.*;
import java.util.Scanner;

public class Ejer9_ModificarUnObjeto {
    public static void main(String[] args) throws IOException {

        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("C:\\Users\\juanc\\Documents\\Datos\\persona.bin"))) {

            //Deserializar objeto persona
            Persona persona = (Persona) in.readObject();

            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce la edad: ");
            int edad = sc.nextInt();
            persona.setEdad(edad);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());

        }
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("C:\\Users\\juanc\\Documents\\Datos\\persona.bin"))) {

           // out.writeObject(persona);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
