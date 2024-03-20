package com.centro.integral.medico.repository;

import com.centro.integral.medico.repository.entity.Paciente;
import com.centro.integral.medico.repository.entity.SignosVitales;
import org.springframework.data.repository.CrudRepository;

public interface SignosVitalesRepository extends CrudRepository<SignosVitales,Integer> {
}
