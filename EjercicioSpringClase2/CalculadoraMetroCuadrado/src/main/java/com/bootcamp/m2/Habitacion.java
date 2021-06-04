package com.bootcamp.m2;

public class Habitacion {

    private final String nombre;
    private final int ancho;
    private final int largo;
    private final int area;

    public Habitacion(String nombre, int ancho, int largo) {
        this.nombre = nombre;
        this.ancho = ancho;
        this.largo = largo;
        this.area = ancho * largo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAncho() {
        return ancho;
    }

    public int getLargo() {
        return largo;
    }

    public int getArea() {
        return area;
    }

}
