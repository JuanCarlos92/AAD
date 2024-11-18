package org.example;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ejer8_LeerDatosNumericos1 {
    public static void main(String[] args) {
        int suma = 0;
        try (DataInputStream in = new DataInputStream (new FileInputStream("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\numeros.bin"))) {

            while (true) {
                try {
                    int num = (int) in.readInt();
                    System.out.println(num);
                    suma = suma + num;
                } catch (IOException e) {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
