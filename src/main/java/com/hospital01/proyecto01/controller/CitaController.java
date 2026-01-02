package com.hospital01.proyecto01.controller;

import com.hospital01.proyecto01.dto.dtoEntrada.CitaRequest;
import com.hospital01.proyecto01.dto.dtoSalida.CitaResponse;
import com.hospital01.proyecto01.service.CitaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/cita")
public class CitaController {
    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    @Operation(summary = "Listar las citas programadas y activas")
    public ResponseEntity<List<CitaResponse>> listar(){
        return ResponseEntity.ok(citaService.listarCita());
    }

    @PostMapping
    @Operation(summary = "Registrar las citas programadas y activas")
    @ApiResponses({@ApiResponse(responseCode = "200",description = "Cita programada satisfactoriamente"),
                   @ApiResponse(responseCode = "400",description = "Datos invalidos")})
    public ResponseEntity<CitaResponse> crearCita(@RequestBody CitaRequest citaRequest){
        CitaResponse citaResponse = citaService.registrarCita(citaRequest);
        return ResponseEntity.ok(citaResponse);
    }

    @PutMapping("/actualizar-cita/{dniPaciente}")
    @Operation(summary = "Actualizar las fechas de cita")
    @ApiResponses({@ApiResponse(responseCode = "200",description = "Cita reporgramada satisfactoriamente"),
                   @ApiResponse(responseCode = "400",description = "No esta actualizada")})
    public ResponseEntity<CitaResponse> actualizarCita(
            @PathVariable String dniPaciente,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate nuevafechaCita
    ){
            return ResponseEntity.ok(citaService.programarCita(dniPaciente,nuevafechaCita));
    }

    @PutMapping("/cancelar-cita/{dniPaciente}")
    @Operation(summary = "Cancelar cita correspondiente")
    @ApiResponses({@ApiResponse(responseCode = "200",description = "Cita cancelada satisfactoriamente"),
            @ApiResponse(responseCode = "400",description = "No esta cancelada")})
    public ResponseEntity<CitaResponse> cancelarCita(
            @PathVariable String dniPaciente
    ){
        return ResponseEntity.ok(citaService.cancelarCita(dniPaciente));
    }
}
