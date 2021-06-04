package com.example.starwars.Repositories;

import com.example.starwars.dtos.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> getPersonajes(String name) throws NoSuchFieldException;
}
