package com.example.DevBack.service;

import com.example.DevBack.model.Paciente;
import com.example.DevBack.repository.PacienteRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente salvar(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> todos(){
        return pacienteRepository.findAll();
    }

    public Paciente porId(Long id){
        return pacienteRepository.findById(id).orElse(null);
    }

    public Paciente atualizar(Long id, Paciente paciente){
        paciente.setId(id);
        return pacienteRepository.save(paciente);
    }

    public boolean excluir(Long id){
        pacienteRepository.deleteById(id);
        return true;
    }
}