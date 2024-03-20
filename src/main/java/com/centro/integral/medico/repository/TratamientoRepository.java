package com.centro.integral.medico.repository;

import com.centro.integral.medico.repository.entity.Paciente;
import com.centro.integral.medico.repository.entity.Tratamiento;
import org.springframework.data.repository.CrudRepository;

public interface TratamientoRepository extends CrudRepository<Tratamiento,Integer> {
}
