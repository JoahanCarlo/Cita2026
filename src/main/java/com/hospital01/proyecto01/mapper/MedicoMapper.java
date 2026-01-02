package com.hospital01.proyecto01.mapper;

import com.hospital01.proyecto01.dto.dtoEntrada.MedicoRequest;
import com.hospital01.proyecto01.dto.dtoSalida.MedicoResponse;
import com.hospital01.proyecto01.model.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MedicoMapper {
    @Mapping(source = "especialidad.nombreEspecialidad",target = "nombreEspecialidad")
    MedicoResponse toResponse(Medico medico);

    Medico toEntity(MedicoRequest medicoRequest);
}
