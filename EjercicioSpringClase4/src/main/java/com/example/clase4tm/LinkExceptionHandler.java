package com.example.clase4tm;

import com.example.clase4tm.dto.ErrorResponseDTO;
import com.example.clase4tm.model.LinkException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkExceptionHandler {

    @ExceptionHandler(LinkException.class)
    public ResponseEntity<ErrorResponseDTO> error(LinkException exception) {
        return new ResponseEntity<>(
                new ErrorResponseDTO(exception.getMessage()),
                exception.getStatus());
    }
}
