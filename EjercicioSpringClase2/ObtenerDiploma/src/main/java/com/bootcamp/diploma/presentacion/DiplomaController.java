package com.bootcamp.diploma.presentacion;

import com.bootcamp.diploma.modelo.Alumno;
import com.bootcamp.diploma.modelo.Diploma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiplomaController {

    @PostMapping("diplomas")
    public ResponseEntity<Diploma> conseguirDiploma(@RequestBody Alumno alumno) {
        Diploma diploma = new Diploma(alumno);
        return new ResponseEntity<>(diploma, HttpStatus.OK);
    }

}
