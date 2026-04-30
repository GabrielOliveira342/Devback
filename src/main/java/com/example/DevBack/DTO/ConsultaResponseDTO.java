package com.example.DevBack.DTO;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConsultaResponseDTO {

    private Long id;
    private LocalDateTime dataHora;
    private String motivo;
    private double valor;
}