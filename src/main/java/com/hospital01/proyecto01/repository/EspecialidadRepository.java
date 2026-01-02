package com.hospital01.proyecto01.repository;

import com.hospital01.proyecto01.dto.dtoSalida.EspecialidadResponse;
import com.hospital01.proyecto01.model.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad,Long> {
}
