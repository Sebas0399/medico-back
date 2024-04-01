package com.centro.integral.medico.service;

import com.centro.integral.medico.repository.entity.HistoriaClinica;

import java.util.List;
import java.util.Optional;

public interface IHistoriaClinicaService {
    public Optional<HistoriaClinica> insertar(HistoriaClinica historiaClinica);

    public Optional<List<HistoriaClinica>> getAll();

    public Optional<List<HistoriaClinica>> getAllFromPaciente(Integer id);


}
