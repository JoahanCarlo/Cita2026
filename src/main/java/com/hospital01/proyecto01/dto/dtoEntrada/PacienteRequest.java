package com.hospital01.proyecto01.dto.dtoEntrada;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Respuesta a la información del paciente")
public class PacienteRequest {
    private String nombrePaciente;
    private String apellidoPaciente;
    private String dniPaciente;
    private String telefonoPaciente;
    private String direccionPaciente;
}
