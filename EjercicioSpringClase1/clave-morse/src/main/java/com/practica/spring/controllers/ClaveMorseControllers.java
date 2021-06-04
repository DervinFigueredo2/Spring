package com.practica.spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Locale;

@RestController
public class ClaveMorseControllers {
    @GetMapping("/devolvercodigomorse/{mensaje}")
    public String devolverCodigoMorse(@PathVariable String mensaje) {
        String result = "";
        char[] letter = {'a', 'b', 'c', 'd', 'e', 'f',
                'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x',
                'y', 'z', '1', '2', '3', '4',
                '5', '6', '7', '8', '9', '0'};

        String[] code
                = {".-", "-...", "-.-.", "-..", ".",
                "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---",
                ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--",
                "--..", ".----", "..---", "...--", "....-", ".....",
                "-....", "--...", "---..", "----.", "-----"};

        HashMap<String, Character> hashmap = new HashMap<>();
        for (int i = 0; i < letter.length; i++) {
            hashmap.put(code[i], letter[i]);
        }

        String[] caracteresIndividuales = mensaje.split(" ");

        for (int i = 0; i < caracteresIndividuales.length; i++) {
            if (caracteresIndividuales[i].equals(" ") || caracteresIndividuales[i].equals(""))
                result += " ";
            else
                result += hashmap.get(caracteresIndividuales[i]);
        }

        return result.toUpperCase(Locale.ROOT);

    }

}