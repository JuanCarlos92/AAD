package org.example;

import java.io.*;

public class Ejer8_LeerDatosNumericos {
    public static void main(String[] args) throws IOException {
        int sumTotal = 0;
        try (DataInputStream in = new DataInputStream
                (new FileInputStream("C:\\Users\\juanc\\Documents\\Datos\\numeros.bin"))) {
            while (true) {
                try {
                    int num = (int) in.readInt();
                    System.out.println(num);
                    sumTotal += num;
                } catch (IOException e) {
                    // Se lanza una excepción al intentar leer más de lo que tiene el archivo
                    break;
                }
            }

        } catch (IOException e) {

            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        System.out.println("Suma total de los numeros:  " + sumTotal);
    }
}

