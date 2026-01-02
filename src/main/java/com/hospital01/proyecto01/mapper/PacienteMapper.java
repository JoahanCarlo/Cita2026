package com.hospital01.proyecto01.mapper;

import com.hospital01.proyecto01.dto.dtoEntrada.PacienteRequest;
import com.hospital01.proyecto01.dto.dtoSalida.PacienteResponse;
import com.hospital01.proyecto01.model.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    Paciente toEntity(PacienteRequest pacienteRequest);

    PacienteResponse toResponse(Paciente paciente);
}
