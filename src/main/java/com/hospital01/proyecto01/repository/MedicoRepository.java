package com.hospital01.proyecto01.repository;

import com.hospital01.proyecto01.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico,Long> {
    Optional<Medico> findByIdAndEspecialidadId(Long medicoId,Long especialidadId);
}
