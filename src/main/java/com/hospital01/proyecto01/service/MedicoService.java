package com.hospital01.proyecto01.service;


import com.hospital01.proyecto01.dto.dtoEntrada.MedicoRequest;
import com.hospital01.proyecto01.dto.dtoSalida.MedicoResponse;
import com.hospital01.proyecto01.mapper.MedicoMapper;
import com.hospital01.proyecto01.model.Especialidad;
import com.hospital01.proyecto01.model.Medico;
import com.hospital01.proyecto01.repository.EspecialidadRepository;
import com.hospital01.proyecto01.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {
    private final MedicoRepository medicoRepository;
    private final MedicoMapper medicoMapper;
    private final EspecialidadRepository especialidadRepository;

    public MedicoService(MedicoRepository medicoRepository, MedicoMapper medicoMapper, EspecialidadRepository especialidadRepository) {
        this.medicoRepository = medicoRepository;
        this.medicoMapper = medicoMapper;
        this.especialidadRepository = especialidadRepository;
    }

    public List<MedicoResponse> listarMedico(){
        return medicoRepository.findAll()
                .stream()
                .map(medicoMapper::toResponse)
                .toList();
    }

    public MedicoResponse registrarMedico(MedicoRequest medicoRequest){
        Especialidad especialidad = especialidadRepository.findById(medicoRequest.getEspecialidadId())
                .orElseThrow(()->new RuntimeException("Especialidad no encontrada"));
        Medico medico = new Medico();
        medico.setNombreMedico(medicoRequest.getNombreMedico());
        medico.setApellidoMedico(medicoRequest.getApellidoMedico());
        medico.setEspecialidad(especialidad);
        Medico medicoGuardado = medicoRepository.save(medico);
        return medicoMapper.toResponse(medicoGuardado);
    }
}
