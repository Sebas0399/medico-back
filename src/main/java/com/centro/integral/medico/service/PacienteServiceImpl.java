package com.centro.integral.medico.service;

import com.centro.integral.medico.repository.HistoriaClinicaRepository;
import com.centro.integral.medico.repository.PacienteRepository;
import com.centro.integral.medico.repository.entity.HistoriaClinica;
import com.centro.integral.medico.repository.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements IPacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    @Override
    public Optional<Paciente> insertar(Paciente paciente) {
        return Optional.of(this.pacienteRepository.save(paciente));
    }

    @Override
    public Optional<Paciente> obtener(String cedula) {
        Optional<Paciente> pacienteEncontrado = pacienteRepository.findByCedula(cedula);
        return pacienteEncontrado;
    }

    @Override
    public Optional<List<Paciente>> obtenerPorNombre(String nombre) {
        return this.pacienteRepository.findByPrimerNombreContainingIgnoreCase(nombre);
    }
}
