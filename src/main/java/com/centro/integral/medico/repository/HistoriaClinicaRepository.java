package com.centro.integral.medico.repository;

import com.centro.integral.medico.repository.entity.HistoriaClinica;
import com.centro.integral.medico.repository.entity.Paciente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface HistoriaClinicaRepository extends CrudRepository<HistoriaClinica,Integer> {
    List<HistoriaClinica> findAll();
}
