package com.hospital01.proyecto01.service;

import com.hospital01.proyecto01.dto.dtoEntrada.EspecialidadRequest;
import com.hospital01.proyecto01.dto.dtoSalida.EspecialidadResponse;
import com.hospital01.proyecto01.mapper.EspecialidadMapper;
import com.hospital01.proyecto01.model.Especialidad;
import com.hospital01.proyecto01.repository.EspecialidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadService {
    private final EspecialidadRepository especialidadRepository;
    private final EspecialidadMapper especialidadMapper;

    public EspecialidadService(EspecialidadRepository especialidadRepository, EspecialidadMapper especialistaMapper, EspecialidadMapper especialidadMapper) {
        this.especialidadRepository = especialidadRepository;
        this.especialidadMapper = especialidadMapper;
    }

    public List<EspecialidadResponse> listar() {
        return especialidadRepository.findAll()
                .stream()
                .map(especialidadMapper::toResponse)
                .toList();
    }

    public EspecialidadResponse registrarEspecialidad(EspecialidadRequest especialidadRequest){
        Especialidad especialidad = especialidadMapper.toEntity(especialidadRequest);
        Especialidad especialidadGuardado = especialidadRepository.save(especialidad);
        return especialidadMapper.toResponse(especialidadGuardado);
    }

    public EspecialidadResponse modificarEspecialidad(Long id,EspecialidadRequest especialidadRequest){
        Especialidad especialidad = especialidadRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Especialidad no encontrada"));
        especialidad.setNombreEspecialidad(especialidad.getNombreEspecialidad());
        Especialidad especialidadActualizado = especialidadRepository.save(especialidad);
        return especialidadMapper.toResponse(especialidadActualizado);
    }
}
