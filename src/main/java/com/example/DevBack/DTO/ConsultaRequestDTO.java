package com.example.DevBack.DTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ConsultaRequestDTO {

    private LocalDateTime dataHora;
    private String motivo;
    private double valor;
}