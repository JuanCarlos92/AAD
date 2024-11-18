package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/*
Escribe un programa que lea el contenido del fichero mensaje.txt y lo imprima en la consola.
*/

public class Ejer2_LeerMensaje {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\mensaje.txt");

        try {
            String mensaje = Files.readString(path);

            System.out.println("El fichero contiene el siguiente mensaje: " + mensaje);


        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
