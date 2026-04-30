package com.example.DevBack.DTO;

import lombok.Data;

@Data
public class ReceitaRequestDTO {

    private String medicamento;
    private String dosagem;
    private int duracaoDias;
}