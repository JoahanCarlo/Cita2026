package com.hospital01.proyecto01.service;

import com.hospital01.proyecto01.dto.dtoEntrada.PacienteRequest;
import com.hospital01.proyecto01.dto.dtoSalida.PacienteResponse;
import com.hospital01.proyecto01.mapper.PacienteMapper;
import com.hospital01.proyecto01.model.Paciente;
import com.hospital01.proyecto01.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;

    public PacienteService(PacienteRepository pacienteRepository, PacienteMapper pacienteMapper) {
        this.pacienteRepository = pacienteRepository;
        this.pacienteMapper = pacienteMapper;
    }

    public List<PacienteResponse> listarPaciente(){
        return pacienteRepository.findAll()
                .stream()
                .map(pacienteMapper::toResponse)
                .toList();
    }

    public PacienteResponse registrarPaciente(PacienteRequest pacienteRequest){
        Paciente paciente = new Paciente();
        paciente.setDniPaciente(pacienteRequest.getDniPaciente());
        paciente.setNombrePaciente(pacienteRequest.getNombrePaciente());
        paciente.setApellidoPaciente(pacienteRequest.getApellidoPaciente());
        paciente.setTelefonoPaciente(pacienteRequest.getTelefonoPaciente());
        paciente.setDireccionPaciente(pacienteRequest.getDireccionPaciente());
        Paciente pacienteGuardado = pacienteRepository.save(paciente);
        return pacienteMapper.toResponse(pacienteGuardado);
    }
}
