package com.centro.integral.medico.service;

import com.centro.integral.medico.repository.HistoriaClinicaRepository;
import com.centro.integral.medico.repository.PacienteRepository;
import com.centro.integral.medico.repository.entity.HistoriaClinica;
import com.centro.integral.medico.repository.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteServiceImpl implements IPacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    @Override
    public Optional<Paciente> insertar(Paciente paciente) {
        HistoriaClinica historiaClinica = new HistoriaClinica();
        paciente.setHistoriaClinica(historiaClinica);
        Paciente pacienteGuardado = pacienteRepository.save(paciente);

        historiaClinica.setPaciente(paciente);
        this.historiaClinicaRepository.save(historiaClinica);

        return Optional.of(pacienteGuardado);
    }

    @Override
    public Optional<Paciente> obtener(String cedula) {
        Optional<Paciente> pacienteEncontrado = pacienteRepository.findByCedula(cedula);
        return pacienteEncontrado;
    }
}
