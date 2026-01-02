package com.hospital01.proyecto01.dto.dtoEntrada;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Respuesta al información")
public class MedicoRequest {
    private String nombreMedico;
    private String apellidoMedico;
    private Long especialidadId;
}
