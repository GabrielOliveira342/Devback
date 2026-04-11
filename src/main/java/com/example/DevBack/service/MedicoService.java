package com.example.DevBack.service;

import com.example.DevBack.model.Medico;
import com.example.DevBack.repository.MedicoRepository;

import java.util.List;

public class MedicoService {

    private MedicoRepository repository;

    public MedicoService(MedicoRepository repository){
        this.repository = repository;
    }

    public Medico salvar(Medico medico){
        return repository.save(medico);
    }

    public List<Medico> todos(){
        return repository.findAll();
    }

    public Medico porId(Long id){
        return repository.findById(id).orElse(null);
    }

    public Medico atualizar(Long id, Medico medico){
        Medico m = repository.findById(id).orElse(null);
        if(m != null){
            m.setNome(medico.getNome());
            return repository.save(m);
        }
        return null;
    }

    public boolean excluir(Long id){
        repository.deleteById(id);
        return true;
    }
}