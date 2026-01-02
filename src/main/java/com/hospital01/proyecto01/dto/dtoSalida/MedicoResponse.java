package com.hospital01.proyecto01.dto.dtoSalida;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicoResponse {
    private Long id;
    private String nombreMedico;
    private String apellidoMedico;
    private String nombreEspecialidad;
}
