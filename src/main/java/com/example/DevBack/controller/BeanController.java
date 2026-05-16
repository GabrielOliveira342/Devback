package com.example.DevBack.controller;

import com.example.DevBack.model.Paciente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bean")
public class BeanController {

    private final Paciente paciente;

    public BeanController(Paciente paciente) {
        this.paciente = paciente;
    }

    @GetMapping
    public Paciente pacienteCompleto() {
        return paciente;
    }
}
