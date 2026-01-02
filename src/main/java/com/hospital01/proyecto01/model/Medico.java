package com.hospital01.proyecto01.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreMedico;
    private String apellidoMedico;
    @ManyToOne
    @JoinColumn(name = "especialidad_id")
    private Especialidad especialidad;
}
