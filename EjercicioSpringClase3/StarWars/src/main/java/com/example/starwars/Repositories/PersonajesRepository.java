package com.example.starwars.Repositories;

import com.example.starwars.dtos.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajesRepository implements IPersonajeRepository{
    private List<Personaje> personajes;

    @Override
    public List<Personaje> getPersonajes(String name) throws NoSuchFieldException{
        return this.personajes.stream()
                .filter(personaje -> personaje.getName().contains(name))
                .collect(Collectors.toList());

    }



    public PersonajesRepository() {
        this.personajes = loadFromDB();
    }

    private List<Personaje> loadFromDB() {
        List<Personaje> ret = null;

        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        var objectMapper = new ObjectMapper();

        try {
            ret = objectMapper.readValue(file, new TypeReference<List<Personaje>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }



}
