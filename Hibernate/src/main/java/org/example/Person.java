package org.example;

public class Person {
    private String nombre;
    private String apellido;
    private String email;

    public Person(String nombre, String email, String apellido) {
        this.nombre = nombre;
        this.email = email;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
