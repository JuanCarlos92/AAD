package org.example;

public class Libro {
    private String titulo;
    private String autor;

    public Libro() {
    }

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public static Libro obtenerLibro(String datos) {
        String[] array = datos.split(", ");
        String titulo = array[0].split(": ")[1];
        String autor = array[1].split(": ")[1];
        return new Libro(titulo, autor);

    }

    @Override
    public String toString() {
        return "titulo: {" + titulo + "} , Autor: {" + autor + "}";
    }
}
