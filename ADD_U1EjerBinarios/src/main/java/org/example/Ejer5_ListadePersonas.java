/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.example;

import java.util.ArrayList;
import java.util.List;

public class Ejer5_ListadePersonas {

    /*
    *Escribe un programa que serialice una lista de objetos Persona en un 
    fichero binario llamado personas.bin. Es recomendable crear una clase a 
    parte de la clase Persona, por ejemplo ls clase SerializarPersonas
     */
    public static void main(String[] args) {
        SerializarLista ObjetSerializarPer = new SerializarLista();
        List<Persona> listaPer = new ArrayList<>();

        //Lsta de objetos persona
        listaPer.add(new Persona("Juan", 25, "Calle de la luna 23"));
        listaPer.add(new Persona("Mario", 80, "Avenida Siempre Viva 2"));
        listaPer.add(new Persona("Oscar", 28, "Calle del Sol 6"));

        //Serializar la lista en persona.bin
        ObjetSerializarPer.serializarPersona(listaPer);

    }

}
