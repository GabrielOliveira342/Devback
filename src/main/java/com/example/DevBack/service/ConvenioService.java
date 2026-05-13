package com.example.DevBack.service;

import com.example.DevBack.exception.RegraNegocioException;
import com.example.DevBack.model.Convenio;
import com.example.DevBack.repository.ConvenioRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConvenioService {

    private ConvenioRepository repository;

    public ConvenioService(ConvenioRepository repository) {
        this.repository = repository;
    }

    public Convenio salvar(Convenio convenio) {
        return repository.save(convenio);
    }

    public List<Convenio> todos() {
        return repository.findAll();
    }

    public Convenio porId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Convênio não encontrado com id: " + id));
    }

    public Convenio atualizar(Long id, Convenio convenio) {
        Convenio c = repository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Convênio não encontrado com id: " + id));
        c.setNome(convenio.getNome());
        c.setCnpj(convenio.getCnpj());
        return repository.save(c);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new RegraNegocioException("Convênio não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
