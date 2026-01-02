package com.hospital01.proyecto01.mapper;

import com.hospital01.proyecto01.dto.dtoEntrada.CitaRequest;
import com.hospital01.proyecto01.dto.dtoSalida.CitaResponse;
import com.hospital01.proyecto01.model.Cita;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CitaMapper {
    Cita toEntity(CitaRequest citaRequest);
    @Mapping(source = "paciente.dniPaciente",target = "dniPaciente")
    @Mapping(source = "paciente.nombrePaciente",target = "nombrePaciente")
    @Mapping(source = "paciente.apellidoPaciente",target = "apellidoPaciente")
    @Mapping(source = "medico.nombreMedico",target = "nombreMedico")
    @Mapping(source = "medico.especialidad.nombreEspecialidad",target = "nombreEspecialidad")
    CitaResponse toResponse(Cita cita);
}
