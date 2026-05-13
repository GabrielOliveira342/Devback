package com.example.DevBack.controller;

import com.example.DevBack.model.Consulta;
import com.example.DevBack.service.ConsultaService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    private ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Consulta salvar(@RequestBody @Valid Consulta consulta) {
        return service.salvar(consulta);
    }

    @GetMapping
    public List<Consulta> todos() {
        return service.todos();
    }

    @GetMapping("{id}")
    public Consulta porId(@PathVariable Long id) {
        return service.porId(id);
    }

    @PutMapping("{id}")
    public Consulta atualizar(@PathVariable Long id, @RequestBody @Valid Consulta consulta) {
        return service.atualizar(id, consulta);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
