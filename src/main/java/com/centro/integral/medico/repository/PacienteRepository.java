package com.centro.integral.medico.repository;

import com.centro.integral.medico.repository.entity.Paciente;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PacienteRepository extends CrudRepository<Paciente,Integer> {
    public Optional<Paciente> findByCedula(String cedula);
}
