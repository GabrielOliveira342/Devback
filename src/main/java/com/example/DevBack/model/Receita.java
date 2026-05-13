package com.example.DevBack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Receita {

    @Id
    private Long id;

    @NotBlank(message = "Medicamento é obrigatório")
    private String medicamento;

    @NotBlank(message = "Dosagem é obrigatória")
    private String dosagem;

    private int duracaoDias;

    @OneToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public int getDuracaoDias() {
        return duracaoDias;
    }

    public void setDuracaoDias(int duracaoDias) {
        this.duracaoDias = duracaoDias;
    }
}
