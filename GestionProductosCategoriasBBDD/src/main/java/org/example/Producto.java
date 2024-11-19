package org.example;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int cagetoria_id;

    public Producto() {
    }

    public Producto(int id, String nombre, double precio, int cagetoria_id) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cagetoria_id = cagetoria_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCagetoria_id() {
        return cagetoria_id;
    }

    public void setCagetoria_id(int cagetoria_id) {
        this.cagetoria_id = cagetoria_id;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre='" + nombre + '\'' + ", precio=" + precio + ", cagetoria_id=" + cagetoria_id + '}';
    }
}
