package com.centro.integral.medico.service.dto;

import com.centro.integral.medico.repository.entity.HistoriaClinica;
import com.centro.integral.medico.repository.entity.SignosVitales;
import com.centro.integral.medico.repository.entity.Tratamiento;
import lombok.Data;

@Data
public class DatosGuardar {
    private HistoriaClinica historiaClinica;
    private Tratamiento tratamiento;
    private SignosVitales signosVitales;
}
