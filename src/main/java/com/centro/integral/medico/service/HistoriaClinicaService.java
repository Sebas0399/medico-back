package com.centro.integral.medico.service;

import com.centro.integral.medico.repository.HistoriaClinicaRepository;
import com.centro.integral.medico.repository.entity.HistoriaClinica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriaClinicaService implements IHistoriaClinicaService {
    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    @Override
    public Optional<HistoriaClinica> insertar(HistoriaClinica historiaClinica) {
        return Optional.of(this.historiaClinicaRepository.save(historiaClinica));
    }

    @Override
    public Optional<List<HistoriaClinica>> getAll() {

        return Optional.of(this.historiaClinicaRepository.findAll());
    }

    @Override
    public Optional<List<HistoriaClinica>> getAllFromPaciente(Integer id) {
        return this.historiaClinicaRepository.findHistoriaClinicaByPaciente_Id(id);
    }
}
