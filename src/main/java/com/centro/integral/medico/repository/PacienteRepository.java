package com.centro.integral.medico.repository;

import com.centro.integral.medico.repository.entity.Paciente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PacienteRepository extends CrudRepository<Paciente,Integer> {
    public Optional<Paciente> findByCedula(String cedula);

    public Optional<List<Paciente>> findByPrimerNombreContainingIgnoreCase(String nombre);

}
