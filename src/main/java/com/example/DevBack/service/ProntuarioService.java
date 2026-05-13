package com.example.DevBack.service;

import com.example.DevBack.exception.RegraNegocioException;
import com.example.DevBack.model.Prontuario;
import com.example.DevBack.repository.ProntuarioRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProntuarioService {

    private ProntuarioRepository repository;

    public ProntuarioService(ProntuarioRepository repository) {
        this.repository = repository;
    }

    public Prontuario salvar(Prontuario prontuario) {
        return repository.save(prontuario);
    }

    public List<Prontuario> todos() {
        return repository.findAll();
    }

    public Prontuario porId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Prontuário não encontrado com id: " + id));
    }

    public Prontuario atualizar(Long id, Prontuario prontuario) {
        Prontuario p = repository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Prontuário não encontrado com id: " + id));
        p.setTipoSanguineo(prontuario.getTipoSanguineo());
        p.setAlergia(prontuario.getAlergia());
        p.setObservacoes(prontuario.getObservacoes());
        return repository.save(p);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new RegraNegocioException("Prontuário não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
