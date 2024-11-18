package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejer2_LeerNombre1 {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\nombre.bin");
        try (InputStream inputHexadecimal = Files.newInputStream(path)) {
            int datosBin;

            System.out.print("Hexadecimal: ");

            while ((datosBin = inputHexadecimal.read()) != -1) {
                System.out.printf("%02X ", datosBin);
            }
            System.out.println("\n");

            try (InputStream inputBinario = Files.newInputStream(path)) {
                int datosBin2;

                System.out.print("Binario: ");

                while ((datosBin2 = inputBinario.read()) != -1) {
                    System.out.printf(String.format("%8s", Integer.toBinaryString(datosBin2)).replace(' ', '0') + " ");
                }
                System.out.println("\n");

                try {
                    String linea = Files.readString(path);
                    System.out.print("Nombre: ");
                    System.out.println(linea);

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
