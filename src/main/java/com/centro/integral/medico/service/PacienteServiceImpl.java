package com.centro.integral.medico.service;

import com.centro.integral.medico.repository.HistoriaClinicaRepository;
import com.centro.integral.medico.repository.PacienteRepository;
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
    public Optional<Paciente> obtener(Integer id) {
        return this.pacienteRepository.findById(id);
    }

    @Override
    public Optional<List<Paciente>> obtenerPorNombre(String nombre) {
        Optional<List<Paciente>> pacientesPrimerNombre = this.pacienteRepository.findByPrimerNombreContainingIgnoreCase(nombre);
        Optional<List<Paciente>> pacientesApellidoPaterno = this.pacienteRepository.findByApellidoPaternoContainingIgnoreCase(nombre);
        Optional<List<Paciente>> pacienteCedula = this.pacienteRepository.findByCedulaContainingIgnoreCase(nombre);
        if (pacienteCedula.get().size() > 0) {
            return pacienteCedula;
        } else if (pacientesApellidoPaterno.get().size() > 0) {
            return pacientesApellidoPaterno;
        } else if (pacientesPrimerNombre.get().size() > 0) {
            return pacientesPrimerNombre;

        } else {
            return Optional.empty();
        }

    }
}
