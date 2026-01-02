package com.hospital01.proyecto01.mapper;

import com.hospital01.proyecto01.dto.dtoEntrada.EspecialidadRequest;
import com.hospital01.proyecto01.dto.dtoSalida.EspecialidadResponse;
import com.hospital01.proyecto01.model.Especialidad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EspecialidadMapper {
    @Mapping(source = "nombreEspecialidad", target = "nombreEspecialidad")
    Especialidad toEntity(EspecialidadRequest especialidadRequest);
    EspecialidadResponse toResponse(Especialidad especialidad);
}
