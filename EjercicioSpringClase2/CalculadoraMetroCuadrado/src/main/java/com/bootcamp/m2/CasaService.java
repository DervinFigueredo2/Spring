package com.bootcamp.m2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CasaService {

    private final static Map<String, Casa> casasPorNombre = new HashMap<>();

    public static void guardarCasa(Casa casa) {
        casasPorNombre.put(casa.getNombre(), casa);
    }

    public static Casa buscarCasa(String nombre) {
        return casasPorNombre.get(nombre);
    }

    public static Optional<Casa> buscarCasaConMayorHabitacion(List<String> nombres) {

        int mayorAreaHabitacion = 0;
        Optional<Casa> casaConMayorHabitacion = Optional.empty();

        for (String nombre : nombres) {

            Casa casa = casasPorNombre.get(nombre);

            for (Habitacion habitacion : casa.getHabitaciones()) {

                if (habitacion.getArea() > mayorAreaHabitacion) {
                    mayorAreaHabitacion = habitacion.getArea();
                    casaConMayorHabitacion = Optional.of(casa);
                }

            }

        }

        return casaConMayorHabitacion;

    }

}
