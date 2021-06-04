package com.bootcamp.diploma.modelo;

import java.util.ArrayList;
import java.util.List;

public class Alumno {

    private final String nombre;
    private final List<Asignatura> asignaturas;

    public Alumno(String nombre, List<Asignatura> asignaturas) {
        this.nombre = nombre;
        this.asignaturas = List.copyOf(asignaturas);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Asignatura> getAsignaturas() {
        return new ArrayList<>(asignaturas);
    }

}
