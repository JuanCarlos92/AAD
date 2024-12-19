package org.example;


import org.example.repository.EstudianteRepository;

public class PruebaEjer14 {
    public static void main(String[] args) {
        EstudianteRepository estudiante = new EstudianteRepository();

        System.out.println(estudiante.obtenerPersonaPorId(2));
        estudiante.eliminarEstudiante(2);


    }
}