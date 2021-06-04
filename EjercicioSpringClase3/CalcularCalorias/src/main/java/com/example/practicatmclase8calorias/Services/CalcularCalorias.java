package com.example.practicatmclase8calorias.Services;

import com.example.practicatmclase8calorias.DTOs.*;
import com.example.practicatmclase8calorias.Repositories.IngredientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalcularCalorias {

    @Autowired
    IngredientesRepository ingredientesRepository;


    public CaloriasTotalesResponseDTO calcularCaloriasPlatillo(PlatoDTO plato) throws NoSuchFieldException {

        double caloriasTotales = 0;
        for (IngredientesPlatilloDTO ingrediente : plato.getIngredientes()) {

            caloriasTotales += CalcularCalorias(ingrediente.getPeso(), ingredientesRepository.getIngredienteNombre(ingrediente.getNombre()).getCalories());
        }
        return new CaloriasTotalesResponseDTO(caloriasTotales);
    }

    public CaloriasPorIngredientesResponseDTO calcularCaloriasIngrediente(PlatoDTO plato) throws NoSuchFieldException {
        List<IngredienteCaloriasDTO> ingredientesCalorias = new ArrayList<>();

        for (IngredientesPlatilloDTO ingrediente : plato.getIngredientes()) {
            double calculo = CalcularCalorias(ingrediente.getPeso(), ingredientesRepository.getIngredienteNombre(ingrediente.getNombre()).getCalories());
            IngredienteCaloriasDTO ingredienteCaloria = new IngredienteCaloriasDTO(ingrediente.getNombre(), calculo);
            ingredientesCalorias.add(ingredienteCaloria);
        }
        return new CaloriasPorIngredientesResponseDTO(ingredientesCalorias);
    }

    public IngredienteCaloriaMayorResponseDTO calcularIngredienteCaloriaMaxima(PlatoDTO plato) throws NoSuchFieldException {
        IngredienteCaloriaMayorResponseDTO ingredienteMax = new IngredienteCaloriaMayorResponseDTO(new IngredienteCaloriasDTO("", 0));
        for (IngredientesPlatilloDTO ingrediente : plato.getIngredientes()) {
            double calculo = CalcularCalorias(ingrediente.getPeso(), ingredientesRepository.getIngredienteNombre(ingrediente.getNombre()).getCalories());
            if (calculo > ingredienteMax.getIngredienteCaloriaMayor().getCalories()) {
                IngredienteCaloriasDTO ingredientecaloriaDTO = new IngredienteCaloriasDTO(ingrediente.getNombre(), calculo);
                ingredienteMax.setIngredienteCaloriaMayor(ingredientecaloriaDTO);
            }
        }
        return ingredienteMax;
    }

    private double CalcularCalorias(double peso, double calorias) {
        return (peso / 100) * calorias;
    }
}
