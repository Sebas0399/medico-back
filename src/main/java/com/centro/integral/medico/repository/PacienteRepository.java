package com.centro.integral.medico.repository;

import com.centro.integral.medico.repository.entity.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface PacienteRepository extends CrudRepository<Paciente,Integer> {
    public Paciente findByCedula(String cedula);
}
