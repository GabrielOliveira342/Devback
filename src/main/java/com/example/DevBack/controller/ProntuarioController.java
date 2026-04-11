package com.example.DevBack.controller;

import com.example.DevBack.model.Prontuario;
import com.example.DevBack.service.ProntuarioService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prontuario")
public class ProntuarioController {

    private ProntuarioService service;

    public ProntuarioController(ProntuarioService service){
        this.service = service;
    }

    @PostMapping
    public Prontuario salvar(@RequestBody Prontuario prontuario){
        return service.salvar(prontuario);
    }

    @GetMapping
    public List<Prontuario> todos(){
        return service.todos();
    }

    @GetMapping("{id}")
    public Prontuario porId(@PathVariable Long id){
        return service.porId(id);
    }

    @PutMapping("{id}")
    public Prontuario atualizar(@PathVariable Long id, @RequestBody Prontuario prontuario){
        return service.atualizar(id, prontuario);
    }

    @DeleteMapping("{id}")
    public boolean excluir(@PathVariable Long id){
        return service.excluir(id);
    }
}