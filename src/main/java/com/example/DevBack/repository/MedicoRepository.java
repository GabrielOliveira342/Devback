package com.example.DevBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.DevBack.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}