package com.example.practicatmclase8calorias.Repositories;

import com.example.practicatmclase8calorias.DTOs.IngredienteCaloriasDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
@Repository
public class IngredientesRepository implements  IIngredientes{
    List<IngredienteCaloriasDTO> ingredientes;

    public IngredientesRepository() {
        this.ingredientes = loadFromDB();
    }

    @Override
    public IngredienteCaloriasDTO getIngredienteNombre(String name) throws NoSuchFieldException {
        return this.ingredientes.stream()
                .filter(ingrediente -> ingrediente.getName().equals(name))
                .findFirst().orElseThrow(NoSuchFieldException::new);
    }
    private List<IngredienteCaloriasDTO> loadFromDB() {
        List<IngredienteCaloriasDTO> ret = null;

        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        var objectMapper = new ObjectMapper();
        //TypeReference<List<BarrioDTO>> typeRef = new TypeReference<>() {};

        try {
            ret = objectMapper.readValue(file, new TypeReference<List<IngredienteCaloriasDTO>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }

}
