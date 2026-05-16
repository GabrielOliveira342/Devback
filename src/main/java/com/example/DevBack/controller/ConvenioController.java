package com.example.DevBack.controller;

import com.example.DevBack.model.Convenio;
import com.example.DevBack.service.ConvenioService;


import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/convenio")
public class ConvenioController {

    private ConvenioService service;

    public ConvenioController(ConvenioService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Convenio salvar(@RequestBody @Validated Convenio convenio) {
        return service.salvar(convenio);
    }

    @GetMapping
    public List<Convenio> todos() {
        return service.todos();
    }

    @GetMapping("{id}")
    public Convenio porId(@PathVariable Long id) {
        return service.porId(id);
    }

    @PutMapping("{id}")
    public Convenio atualizar(@PathVariable Long id, @RequestBody @Validated Convenio convenio) {
        return service.atualizar(id, convenio);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
