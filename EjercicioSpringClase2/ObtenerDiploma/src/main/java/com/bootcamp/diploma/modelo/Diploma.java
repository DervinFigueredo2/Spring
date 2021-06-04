package com.bootcamp.diploma.modelo;

import java.util.List;

public class Diploma {

    private final static double BUEN_PROMEDIO = 9;
    private final static String MENSAJE_BUEN_PROMEDIO = "mensaje especial";
    private final static String MENSAJE_GENERAL = "mensaje comun";

    private final String mensaje;
    private final double promedio;
    private final Alumno alumno;

    public Diploma(Alumno alumno) {
        this.alumno = alumno;
        List<Asignatura> asignaturas = alumno.getAsignaturas();
        this.promedio = asignaturas.stream().mapToDouble(Asignatura::getNota).sum() / asignaturas.size();
        this.mensaje = this.promedio >= BUEN_PROMEDIO ? MENSAJE_BUEN_PROMEDIO : MENSAJE_GENERAL;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public String getMensaje() {
        return mensaje;
    }

    public double getPromedio() {
        return promedio;
    }

}
