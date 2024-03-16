package com.centro.integral.medico.service;

import com.centro.integral.medico.repository.PacienteRepository;
import com.centro.integral.medico.repository.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteServiceImpl implements IPacienteService{
    @Autowired
    private PacienteRepository pacienteRepository;
    @Override
    public Optional<Paciente> insertar(Paciente paciente) {
        Paciente pacienteGuardado = pacienteRepository.save(paciente);
        return Optional.of(pacienteGuardado);
    }

    @Override
    public Optional<Paciente> obtener(String cedula) {
        Paciente pacienteEncontrado=pacienteRepository.findByCedula(cedula);
        return Optional.of(pacienteEncontrado);
    }
}
