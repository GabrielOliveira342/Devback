package com.example.DevBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.DevBack.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}