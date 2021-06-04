package com.example.clase4tm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class LinkException extends Exception{
    private String message;
    private HttpStatus status;
}
