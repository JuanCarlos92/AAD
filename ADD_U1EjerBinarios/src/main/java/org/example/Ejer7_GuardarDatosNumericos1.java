package org.example;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Ejer7_GuardarDatosNumericos1 {
    public static void main(String[] args) {
        int[]numeros = new int[10];
        Random rand = new Random();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = rand.nextInt(100);
        }
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\numeros.bin"))){
            for (int num : numeros) {
                out.writeInt(num);
            }
            System.out.println("10 numeros generados automaticamente");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
