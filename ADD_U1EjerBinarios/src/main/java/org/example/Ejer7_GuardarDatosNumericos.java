package org.example;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Random;

public class Ejer7_GuardarDatosNumericos {
    public static void main(String[] args) {
        int []array = new int[10];
        Random numeroRandom = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = numeroRandom.nextInt(100)+1;
        }
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("C:\\Users\\juanc\\Documents\\Datos\\numeros.bin"))){
            for (int num : array){
                out.writeInt(num);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
