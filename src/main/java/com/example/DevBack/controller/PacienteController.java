package com.example.DevBack.controller;

import com.example.DevBack.model.Paciente;
import com.example.DevBack.service.PacienteService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente salvar(@RequestBody @Valid Paciente paciente) {
        return service.salvar(paciente);
    }

    @GetMapping
    public List<Paciente> todos() {
        return service.todos();
    }

    @GetMapping("{id}")
    public Paciente porId(@PathVariable Long id) {
        return service.porId(id);
    }

    @PutMapping("{id}")
    public Paciente atualizar(@PathVariable Long id, @RequestBody @Valid Paciente paciente) {
        return service.atualizar(id, paciente);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
