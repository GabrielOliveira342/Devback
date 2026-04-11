package com.example.DevBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.DevBack.model.Prontuario;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {
}