package com.example.practicatmclase8calorias.Controllers;

import com.example.practicatmclase8calorias.DTOs.CaloriasPorIngredientesResponseDTO;
import com.example.practicatmclase8calorias.DTOs.CaloriasTotalesResponseDTO;
import com.example.practicatmclase8calorias.DTOs.IngredienteCaloriaMayorResponseDTO;
import com.example.practicatmclase8calorias.DTOs.PlatoDTO;
import com.example.practicatmclase8calorias.Services.CalcularCalorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class IngredienteController {

@Autowired
public CalcularCalorias calcularCalorias;



@PostMapping("/total")
    public ResponseEntity<CaloriasTotalesResponseDTO> postCaloriasTotalesPlato(@RequestBody PlatoDTO plato) throws NoSuchFieldException {
        return new ResponseEntity<>(calcularCalorias.calcularCaloriasPlatillo(plato), HttpStatus.OK);
    }

    @PostMapping("/caloria-por-ingrediente")
    public ResponseEntity<CaloriasPorIngredientesResponseDTO> postCaloriasIngrediente(@RequestBody PlatoDTO plato) throws NoSuchFieldException {
        return new ResponseEntity<>(calcularCalorias.calcularCaloriasIngrediente(plato), HttpStatus.OK);
    }

    @PostMapping("/ingrediente-maximo")
    public ResponseEntity<IngredienteCaloriaMayorResponseDTO> postIngredienteMaximo(@RequestBody PlatoDTO plato) throws NoSuchFieldException {
        return new ResponseEntity<>(calcularCalorias.calcularIngredienteCaloriaMaxima(plato), HttpStatus.OK);
    }



}
