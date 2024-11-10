package co.taller2.grupo12.grupo12.DTOS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import co.taller2.grupo12.grupo12.enums.Gama;
import co.taller2.grupo12.grupo12.enums.SistemaOperativo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CelularDTO {
    private Long id;
    
    private String marca;
    private Long serial;
    private LocalDate fechaCompra;
    private LocalDate anioLanzamiento;
    private double precio;
    private SistemaOperativo os;
    private Gama gama;
}
