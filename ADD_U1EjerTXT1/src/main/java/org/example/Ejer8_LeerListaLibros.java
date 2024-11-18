package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejer8_LeerListaLibros {
    public static void main(String[] args){
        Path path = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\libros.txt");
        try {
            File fileFibros = new File(path.toString());
            Scanner sc = new Scanner(fileFibros);

            int numLibros = 1;

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                System.out.println(numLibros + ". " + linea);
                numLibros++;
            }
            sc.close();

        }catch (FileNotFoundException e) {
            e.printStackTrace();

        }



    }
}
