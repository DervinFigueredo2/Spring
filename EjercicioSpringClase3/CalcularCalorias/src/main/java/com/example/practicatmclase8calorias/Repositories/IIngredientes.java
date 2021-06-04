package com.example.practicatmclase8calorias.Repositories;

import com.example.practicatmclase8calorias.DTOs.IngredienteCaloriasDTO;

public interface IIngredientes {
    IngredienteCaloriasDTO getIngredienteNombre(String name) throws NoSuchFieldException;
}
