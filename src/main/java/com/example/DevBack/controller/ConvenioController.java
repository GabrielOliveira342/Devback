package com.example.DevBack.controller;

import com.example.DevBack.model.Convenio;
import com.example.DevBack.service.ConvenioService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/convenio")
public class ConvenioController {

    private ConvenioService service;

    public ConvenioController(ConvenioService service){
        this.service = service;
    }

    @PostMapping
    public Convenio salvar(@RequestBody Convenio convenio){
        return service.salvar(convenio);
    }

    @GetMapping
    public List<Convenio> todos(){
        return service.todos();
    }

    @GetMapping("{id}")
    public Convenio porId(@PathVariable Long id){
        return service.porId(id);
    }

    @PutMapping("{id}")
    public Convenio atualizar(@PathVariable Long id, @RequestBody Convenio convenio){
        return service.atualizar(id, convenio);
    }

    @DeleteMapping("{id}")
    public boolean excluir(@PathVariable Long id){
        return service.excluir(id);
    }
}