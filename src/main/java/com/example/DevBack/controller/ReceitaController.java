package com.example.DevBack.controller;

import com.example.DevBack.model.Receita;
import com.example.DevBack.service.ReceitaService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

    private ReceitaService service;

    public ReceitaController(ReceitaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Receita salvar(@RequestBody @Valid Receita receita) {
        return service.salvar(receita);
    }

    @GetMapping
    public List<Receita> todos() {
        return service.todos();
    }

    @GetMapping("{id}")
    public Receita porId(@PathVariable Long id) {
        return service.porId(id);
    }

    @PutMapping("{id}")
    public Receita atualizar(@PathVariable Long id, @RequestBody @Valid Receita receita) {
        return service.atualizar(id, receita);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
