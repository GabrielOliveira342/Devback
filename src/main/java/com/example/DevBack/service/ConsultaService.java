package com.example.DevBack.service;

import com.example.DevBack.model.Consulta;
import com.example.DevBack.repository.ConsultaRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    private ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository){
        this.consultaRepository = consultaRepository;
    }

    public Consulta salvar(Consulta consulta){
        return consultaRepository.save(consulta);
    }

    public List<Consulta> todos(){
        return consultaRepository.findAll();
    }

    public Consulta porId(Long id){
        return consultaRepository.findById(id).orElse(null);
    }

    public Consulta atualizar(Long id, Consulta consulta){
        consulta.setId(id);
        return consultaRepository.save(consulta);
    }

    public boolean excluir(Long id){
        consultaRepository.deleteById(id);
        return true;
    }
}