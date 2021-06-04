package com.bootcamp.diploma.modelo;

public class Asignatura {

    private final String nombre;
    private final double nota;

    public Asignatura(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }

}
