package com.hospital01.proyecto01.dto.dtoSalida;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CitaResponse {
    private Long id;
    private String dniPaciente;
    private String nombrePaciente;
    private String apellidoPaciente;
    private String nombreEspecialidad;
    private String nombreMedico;
    private LocalDate fechaCita;
    private LocalDate fechaRegistro;
    private Boolean estado;

    public Integer getEstado(){
        return estado != null && estado ? 1 : 0;
    }
}
