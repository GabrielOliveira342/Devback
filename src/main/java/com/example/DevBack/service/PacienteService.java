package com.example.DevBack.service;

import com.example.DevBack.exception.RegraNegocioException;
import com.example.DevBack.model.Paciente;
import com.example.DevBack.repository.PacienteRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente salvar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> todos() {
        return pacienteRepository.findAll();
    }

    public Paciente porId(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Paciente não encontrado com id: " + id));
    }

    public Paciente atualizar(Long id, Paciente paciente) {
        if (!pacienteRepository.existsById(id)) {
            throw new RegraNegocioException("Paciente não encontrado com id: " + id);
        }
        paciente.setId(id);
        return pacienteRepository.save(paciente);
    }

    public void excluir(Long id) {
        if (!pacienteRepository.existsById(id)) {
            throw new RegraNegocioException("Paciente não encontrado com id: " + id);
        }
        pacienteRepository.deleteById(id);
    }
}
