package com.example.DevBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.DevBack.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}