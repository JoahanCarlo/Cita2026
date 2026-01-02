package com.hospital01.proyecto01.controller;

import com.hospital01.proyecto01.dto.dtoEntrada.PacienteRequest;
import com.hospital01.proyecto01.dto.dtoSalida.PacienteResponse;
import com.hospital01.proyecto01.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    @Operation(summary = "Listar los pacientes")
    public ResponseEntity<List<PacienteResponse>> listar(){
        return ResponseEntity.ok(pacienteService.listarPaciente());
    }

    @PostMapping
    @Operation(summary = "Registrar a los pacientes")
    @ApiResponses({@ApiResponse(responseCode = "200",description = "Paciente registrado satisfactoriamente"),
                   @ApiResponse(responseCode = "400",description = "Datos invalidados")})
    public ResponseEntity<PacienteResponse> crearPaciente(@RequestBody PacienteRequest pacienteRequest){
        PacienteResponse pacienteResponse = pacienteService.registrarPaciente(pacienteRequest);
        return ResponseEntity.ok(pacienteResponse);
    }
}
