package com.example.DevBack.controller;

import com.example.DevBack.model.Medico;
import com.example.DevBack.service.MedicoService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medico salvar(@RequestBody @Valid Medico medico) {
        return service.salvar(medico);
    }

    @GetMapping
    public List<Medico> todos() {
        return service.todos();
    }

    @GetMapping("{id}")
    public Medico porId(@PathVariable Long id) {
        return service.porId(id);
    }

    @PutMapping("{id}")
    public Medico atualizar(@PathVariable Long id, @RequestBody @Valid Medico medico) {
        return service.atualizar(id, medico);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
