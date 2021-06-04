package com.example.starwars.Controllers;

import com.example.starwars.Repositories.IPersonajeRepository;
import com.example.starwars.Service.ObtenerPersonajes;
import com.example.starwars.dtos.Personaje;
import com.example.starwars.dtos.PersonajesEncontradosRespondDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StarWarsControllers {

    @Autowired
    private ObtenerPersonajes obtenerPersonaje;

    @GetMapping("/personaje/{name}")
    public ResponseEntity<PersonajesEncontradosRespondDTO> getObtenerPersonajes (@PathVariable String name){
        try {
            return new ResponseEntity<>( obtenerPersonaje.obtenerPersonajes(name), HttpStatus.OK);
        }catch (NoSuchFieldException e){
            System.out.println("No se encontro un personaje");
            e.printStackTrace();
            return new ResponseEntity<>(new PersonajesEncontradosRespondDTO(new ArrayList<>()),HttpStatus.NOT_FOUND);
        }



    }

}
