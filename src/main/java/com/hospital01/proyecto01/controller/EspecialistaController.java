package com.hospital01.proyecto01.controller;

import com.hospital01.proyecto01.dto.dtoEntrada.EspecialidadRequest;
import com.hospital01.proyecto01.dto.dtoSalida.EspecialidadResponse;
import com.hospital01.proyecto01.service.EspecialidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidad")
public class EspecialistaController {
    private final EspecialidadService especialidadService;

    public EspecialistaController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    @GetMapping
    public ResponseEntity<List<EspecialidadResponse>> listar(){
        return ResponseEntity.ok(especialidadService.listar());
    }

    @PostMapping
    public ResponseEntity<EspecialidadResponse> crearEspecialidad(@RequestBody EspecialidadRequest especialidadRequest) {
        EspecialidadResponse especialidadResponse = especialidadService.registrarEspecialidad(especialidadRequest);
        return ResponseEntity.ok(especialidadResponse);
    }
}
