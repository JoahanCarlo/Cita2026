package com.hospital01.proyecto01.dto.dtoEntrada;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitaRequest {
    private String dniPaciente;
    private Long medicoId;
    private LocalDate fechaCita;
}
