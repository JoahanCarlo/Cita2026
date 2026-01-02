package com.hospital01.proyecto01.controller;

import com.hospital01.proyecto01.dto.dtoEntrada.MedicoRequest;
import com.hospital01.proyecto01.dto.dtoSalida.MedicoResponse;
import com.hospital01.proyecto01.mapper.MedicoMapper;
import com.hospital01.proyecto01.service.MedicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    private final MedicoService medicoService;
    private final MedicoMapper medicoMapper;

    public MedicoController(MedicoService medicoService, MedicoMapper medicoMapper) {
        this.medicoService = medicoService;
        this.medicoMapper = medicoMapper;
    }

    @GetMapping
    public ResponseEntity<List<MedicoResponse>> listarMedico(){
        return ResponseEntity.ok(medicoService.listarMedico());
    }

    @PostMapping
    @Operation(summary = "Registrar a los médicos")
    @ApiResponses({@ApiResponse(responseCode = "200",description = "Medico registrado correctamente"),
                   @ApiResponse(responseCode = "400",description = "Datos invalidos")})
    public ResponseEntity<MedicoResponse> crearMedico(@RequestBody MedicoRequest medicoRequest){
        MedicoResponse medicoResponse = medicoService.registrarMedico(medicoRequest);
        return ResponseEntity.ok(medicoResponse);
    }
}
