package com.centro.integral.medico.service;

import com.centro.integral.medico.repository.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {
    public Optional<Paciente> insertar(Paciente paciente);

    public Optional<Paciente> obtener(String cedula);

    public Optional<Paciente> obtener(Integer id);

    public Optional<List<Paciente>> obtenerPorNombre(String nombre);


}
