package org.example.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private List<Estudiante> estudiantes;

    // Constructores, getters y setters
    public Empresa() {}

    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public void addEstudiante(Estudiante estudiante) {
        if (estudiantes == null) {
            estudiantes = new ArrayList<>();
        }
        estudiantes.add(estudiante);
        estudiante.setEmpresa(this);  // Relación bidireccional
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setPersonas(List<Estudiante> personas) {
        this.estudiantes = personas;
    }
}