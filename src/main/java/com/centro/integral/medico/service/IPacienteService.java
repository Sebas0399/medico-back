package com.centro.integral.medico.service;

import com.centro.integral.medico.repository.entity.Paciente;

import java.util.Optional;

public interface IPacienteService {
    public Optional<Paciente>insertar(Paciente paciente);
    public Optional<Paciente>obtener(String cedula);

}
