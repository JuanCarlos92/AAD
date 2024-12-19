package org.example;

import org.example.dto.Estudiante;
import org.example.repository.EstudianteRepository;

import java.util.List;

public class PruebaEjer15 {
    public static void main(String[] args) {
        EstudianteRepository repository = new EstudianteRepository();

        // Crear e insertar estudiantes
        Estudiante estudiante1 = new Estudiante("Juan","Rodriguez","juan@email.com" ,18);
        Estudiante estudiante2 = new Estudiante("Ana","Mendez","ana@email.com", 21);
        Estudiante estudiante3 = new Estudiante("Pedro","Alvarez","pedro@gmail.com", 25);

        repository.guardarEstudiante(estudiante1);
        repository.guardarEstudiante(estudiante2);
        repository.guardarEstudiante(estudiante3);

        // Obtener estudiantes con edad mayor a 20
        List<Estudiante> estudiantesMayores = repository.obtenerEstudiantesConEdadMayorA(20);

        // Imprimir resultados
        System.out.println("Estudiantes con edad mayor a 20 años:");
        for (Estudiante e : estudiantesMayores) {
            System.out.println(e);
        }
        repository.cerrar();
    }
}
