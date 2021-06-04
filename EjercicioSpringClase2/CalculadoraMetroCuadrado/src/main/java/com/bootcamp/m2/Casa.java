package com.bootcamp.m2;

import java.util.ArrayList;
import java.util.List;

public class Casa {

    private final static int precioM2 = 800;

    private final String nombre;
    private final String direccion;
    private final List<Habitacion> habitaciones;
    private final int area;
    private final int precio;

    public Casa(String nombre, String direccion, List<Habitacion> habitaciones) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.habitaciones = List.copyOf(habitaciones);
        this.area = this.habitaciones.stream().mapToInt(Habitacion::getArea).sum();
        this.precio = this.area * precioM2;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Habitacion> getHabitaciones() {
        return new ArrayList<>(habitaciones);
    }

    public int getArea() {
        return area;
    }

    public int getPrecio() {
        return precio;
    }

}
