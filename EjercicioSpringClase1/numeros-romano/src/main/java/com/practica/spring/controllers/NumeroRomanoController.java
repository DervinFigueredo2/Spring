package com.practica.spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.TreeMap;

@RestController
public class NumeroRomanoController {
    @GetMapping(path = "/numerosRomanos/{numero}")
    public String convertirNumero(@PathVariable int numero) {
        String romano= toRoman(numero);

        return "El numero en romano es: " + romano;
    }

    private String toRoman(int number) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        int l = map.floorKey(number);
        if (number == l) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number - l);
    }
}