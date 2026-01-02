package com.hospital01.proyecto01.repository;

import com.hospital01.proyecto01.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    Optional<Paciente> findByDniPaciente(String dniPaciente);
}
