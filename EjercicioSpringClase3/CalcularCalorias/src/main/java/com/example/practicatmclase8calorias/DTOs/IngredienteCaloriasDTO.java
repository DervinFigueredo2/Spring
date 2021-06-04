package com.example.practicatmclase8calorias.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredienteCaloriasDTO {
    private String name;
    private double calories;

}
