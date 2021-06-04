package com.example.starwars.Service;

import com.example.starwars.Repositories.IPersonajeRepository;
import com.example.starwars.dtos.Personaje;
import com.example.starwars.dtos.PersonajesEncontradosRespondDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary

public class ObtenerPersonajes {
    @Autowired
    IPersonajeRepository personajeRepository;
    public PersonajesEncontradosRespondDTO obtenerPersonajes(String name) throws NoSuchFieldException {
            return new PersonajesEncontradosRespondDTO(personajeRepository.getPersonajes(name));
    }
}
