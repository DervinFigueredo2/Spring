package com.example.clase4tm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkDTO{
    private String url;
    private String password;
    private Boolean valido;
}
