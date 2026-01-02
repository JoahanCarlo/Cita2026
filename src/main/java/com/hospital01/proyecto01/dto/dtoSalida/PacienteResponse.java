package com.hospital01.proyecto01.dto.dtoSalida;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PacienteResponse {
    private Long id;
    private String nombrePaciente;
    private String apellidoPaciente;
    private String dniPaciente;
    private String telefonoPaciente;
    private String direccionPaciente;
}
