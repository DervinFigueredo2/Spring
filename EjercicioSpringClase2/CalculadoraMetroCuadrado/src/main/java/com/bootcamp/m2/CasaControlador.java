package com.bootcamp.m2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CasaControlador {

    @PostMapping("casas")
    public ResponseEntity<Casa> guardarCasa(@RequestBody Casa casa) {
        CasaService.guardarCasa(casa);
        Casa casaGuardada = CasaService.buscarCasa(casa.getNombre());
        return new ResponseEntity<>(casaGuardada, HttpStatus.OK);
    }

    @GetMapping("casas/{nombre}/area")
    public ResponseEntity<Integer> buscarArea(@PathVariable String nombre) {
        Casa casa = CasaService.buscarCasa(nombre);
        return new ResponseEntity<>(casa.getArea(), HttpStatus.OK);
    }

    @GetMapping("casas/{nombre}/precio")
    public ResponseEntity<Integer> buscarPrecio(@PathVariable String nombre) {
        Casa casa = CasaService.buscarCasa(nombre);
        return new ResponseEntity<>(casa.getPrecio(), HttpStatus.OK);
    }

    @GetMapping("casas/mayor-habitacion")
    public ResponseEntity<Casa> buscarCasaConMayorHabitacion(@RequestParam List<String> nombres) {
        Optional<Casa> casa = CasaService.buscarCasaConMayorHabitacion(nombres);
        return new ResponseEntity<>(casa.get(), HttpStatus.OK);
    }

    @GetMapping("casas/{nombre}/habitaciones")
    public ResponseEntity<List<Habitacion>> buscarCasaConMayorHabitacion(@PathVariable String nombre) {
        Casa casa = CasaService.buscarCasa(nombre);
        return new ResponseEntity<>(casa.getHabitaciones(), HttpStatus.OK);
    }

}
