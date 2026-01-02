package com.hospital01.proyecto01.repository;

import com.hospital01.proyecto01.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CitaRepository extends JpaRepository<Cita,Long> {
    Optional<Cita> findByPacienteDniPaciente(String dniPaciente);
    List<Cita> findByEstadoTrue();
}
