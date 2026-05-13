package com.example.DevBack.service;

import com.example.DevBack.exception.RegraNegocioException;
import com.example.DevBack.model.Receita;
import com.example.DevBack.repository.ReceitaRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {

    private ReceitaRepository receitaRepository;

    public ReceitaService(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    public Receita salvar(Receita receita) {
        return receitaRepository.save(receita);
    }

    public List<Receita> todos() {
        return receitaRepository.findAll();
    }

    public Receita porId(Long id) {
        return receitaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Receita não encontrada com id: " + id));
    }

    public Receita atualizar(Long id, Receita receita) {
        if (!receitaRepository.existsById(id)) {
            throw new RegraNegocioException("Receita não encontrada com id: " + id);
        }
        receita.setId(id);
        return receitaRepository.save(receita);
    }

    public void excluir(Long id) {
        if (!receitaRepository.existsById(id)) {
            throw new RegraNegocioException("Receita não encontrada com id: " + id);
        }
        receitaRepository.deleteById(id);
    }
}
