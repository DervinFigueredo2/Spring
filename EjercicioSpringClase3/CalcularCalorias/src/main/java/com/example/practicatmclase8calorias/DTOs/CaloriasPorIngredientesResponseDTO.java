package com.example.practicatmclase8calorias.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaloriasPorIngredientesResponseDTO {
    private List<IngredienteCaloriasDTO> ingredientesCalorias;
}
