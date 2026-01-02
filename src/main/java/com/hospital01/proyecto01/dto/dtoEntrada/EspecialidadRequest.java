package com.hospital01.proyecto01.dto.dtoEntrada;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Ingresar la especialidad correspondiente")
public class EspecialidadRequest {
    private String nombreEspecialidad;
}
