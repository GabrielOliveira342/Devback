package com.example.DevBack.controller;

import com.example.DevBack.model.Receita;
import com.example.DevBack.service.ReceitaService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

    private ReceitaService service;

    public ReceitaController(ReceitaService service){
        this.service = service;
    }

    @PostMapping
    public Receita salvar(@RequestBody Receita receita){
        return service.salvar(receita);
    }

    @GetMapping
    public List<Receita> todos(){
        return service.todos();
    }

    @GetMapping("{id}")
    public Receita porId(@PathVariable Long id){
        return service.porId(id);
    }

    @PutMapping("{id}")
    public Receita atualizar(@PathVariable Long id, @RequestBody Receita receita){
        return service.atualizar(id, receita);
    }

    @DeleteMapping("{id}")
    public boolean excluir(@PathVariable Long id){
        return service.excluir(id);
    }
}