package com.example.DevBack.service;

import com.example.DevBack.model.Prontuario;
import com.example.DevBack.repository.ProntuarioRepository;

import java.util.List;

public class ProntuarioService {

    private ProntuarioRepository repository;

    public ProntuarioService(ProntuarioRepository repository){
        this.repository = repository;
    }

    public Prontuario salvar(Prontuario prontuario){
        return repository.save(prontuario);
    }

    public List<Prontuario> todos(){
        return repository.findAll();
    }

    public Prontuario porId(Long id){
        return repository.findById(id).orElse(null);
    }

    public Prontuario atualizar(Long id, Prontuario prontuario){
        Prontuario p = repository.findById(id).orElse(null);
        if(p != null){
            p.setTipoSanguineo(prontuario.getTipoSanguineo());
            p.setAlergia(prontuario.getAlergia());
            p.setObservacoes(prontuario.getObservacoes());
            return repository.save(p);
        }
        return null;
    }

    public boolean excluir(Long id){
        repository.deleteById(id);
        return true;
    }
}