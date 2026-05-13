package com.example.DevBack.service;

import com.example.DevBack.exception.RegraNegocioException;
import com.example.DevBack.model.Medico;
import com.example.DevBack.repository.MedicoRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public Medico salvar(Medico medico) {
        return repository.save(medico);
    }

    public List<Medico> todos() {
        return repository.findAll();
    }

    public Medico porId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Médico não encontrado com id: " + id));
    }

    public Medico atualizar(Long id, Medico medico) {
        Medico m = repository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Médico não encontrado com id: " + id));
        m.setNome(medico.getNome());
        m.setEspecialidade(medico.getEspecialidade());
        m.setCrm(medico.getCrm());
        return repository.save(m);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new RegraNegocioException("Médico não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
