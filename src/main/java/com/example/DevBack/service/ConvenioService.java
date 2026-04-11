package com.example.DevBack.service;

import com.example.DevBack.model.Convenio;
import com.example.DevBack.repository.ConvenioRepository;

import java.util.List;

public class ConvenioService {

    private ConvenioRepository repository;

    public ConvenioService(ConvenioRepository repository){
        this.repository = repository;
    }

    public Convenio salvar(Convenio convenio){
        return repository.save(convenio);
    }

    public List<Convenio> todos(){
        return repository.findAll();
    }

    public Convenio porId(Long id){
        return repository.findById(id).orElse(null);
    }

    public Convenio atualizar(Long id, Convenio convenio){
        Convenio c = repository.findById(id).orElse(null);
        if(c != null){
            c.setNome(convenio.getNome());
            return repository.save(c);
        }
        return null;
    }

    public boolean excluir(Long id){
        repository.deleteById(id);
        return true;
    }
}