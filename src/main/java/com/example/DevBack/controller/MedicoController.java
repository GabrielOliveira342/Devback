package com.example.DevBack.controller;

import com.example.DevBack.model.Medico;
import com.example.DevBack.service.MedicoService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private MedicoService service;

    public MedicoController(MedicoService service){
        this.service = service;
    }

    @PostMapping
    public Medico salvar(@RequestBody Medico medico){
        return service.salvar(medico);
    }

    @GetMapping
    public List<Medico> todos(){
        return service.todos();
    }

    @GetMapping("{id}")
    public Medico porId(@PathVariable Long id){
        return service.porId(id);
    }

    @PutMapping("{id}")
    public Medico atualizar(@PathVariable Long id, @RequestBody Medico medico){
        return service.atualizar(id, medico);
    }

    @DeleteMapping("{id}")
    public boolean excluir(@PathVariable Long id){
        return service.excluir(id);
    }
}