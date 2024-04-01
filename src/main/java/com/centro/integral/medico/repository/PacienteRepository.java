package com.centro.integral.medico.repository;

import com.centro.integral.medico.repository.entity.Paciente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PacienteRepository extends CrudRepository<Paciente, Integer> {
    public Optional<Paciente> findByCedula(String cedula);

    public Optional<Paciente> findById(Integer id);

    public Optional<List<Paciente>> findByPrimerNombreContainingIgnoreCase(String nombre);

    public Optional<List<Paciente>> findBySegundoNombreContainingIgnoreCase(String nombre);

    public Optional<List<Paciente>> findByApellidoPaternoContainingIgnoreCase(String apellido);

    public Optional<List<Paciente>> findByApellidoMaternoContainingIgnoreCase(String apellido);

    public Optional<List<Paciente>> findByCedulaContainingIgnoreCase(String cedula);


}
