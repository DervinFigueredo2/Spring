package com.example.starwars.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personaje {

    private String name;
    private Object height;
    private Object mass;
    private String hair_color;
    private String skin_color;
    private String birth_year;
    private String eye_color;
    private String gender;
    private String homeworld;
    private String species;
}
