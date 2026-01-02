package com.hospital01.proyecto01.service;

import com.hospital01.proyecto01.dto.dtoEntrada.CitaRequest;
import com.hospital01.proyecto01.dto.dtoSalida.CitaResponse;
import com.hospital01.proyecto01.mapper.CitaMapper;
import com.hospital01.proyecto01.model.Cita;
import com.hospital01.proyecto01.model.Medico;
import com.hospital01.proyecto01.model.Paciente;
import com.hospital01.proyecto01.repository.CitaRepository;
import com.hospital01.proyecto01.repository.MedicoRepository;
import com.hospital01.proyecto01.repository.PacienteRepository;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CitaService {
    private final CitaRepository citaRepository;
    private final CitaMapper citaMapper;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;

    public CitaService(CitaRepository citaRepository, CitaMapper citaMapper, MedicoRepository medicoRepository, PacienteRepository pacienteRepository) {
        this.citaRepository = citaRepository;
        this.citaMapper = citaMapper;
        this.medicoRepository = medicoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public List<CitaResponse> listarCita() {
        return citaRepository.findByEstadoTrue()
                .stream()
                .map(citaMapper::toResponse)
                .toList();
    }

    public CitaResponse registrarCita(CitaRequest citaRequest) {
        Medico medico = medicoRepository.findById(citaRequest.getMedicoId())
                .orElseThrow(() -> new RuntimeException("Medico no encontrado"));
        Paciente paciente = pacienteRepository.findByDniPaciente(citaRequest.getDniPaciente())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado su DNI"));
        Cita cita = new Cita();
        cita.setPaciente(paciente);
        cita.setMedico(medico);
        cita.setFechaCita(citaRequest.getFechaCita());
        cita.setEstado(true);
        Cita citaGuardado = citaRepository.save(cita);
        return citaMapper.toResponse(citaGuardado);
    }

    public CitaResponse programarCita(String dniPaciente,LocalDate nuevaFechaCita){
        Cita cita = citaRepository.findByPacienteDniPaciente(dniPaciente)
                .orElseThrow(()->new RuntimeException("Cita no encontrada"));
        cita.setFechaCita(nuevaFechaCita);
        return citaMapper.toResponse(citaRepository.save(cita));
    }

    public CitaResponse cancelarCita(String dniPaciente){
        Cita cita = citaRepository.findByPacienteDniPaciente(dniPaciente)
                .orElseThrow(()->new RuntimeException("Cita no encontrada"));
        cita.setEstado(false);
        return citaMapper.toResponse(citaRepository.save(cita));
    }
}
