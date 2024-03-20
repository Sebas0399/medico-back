package com.centro.integral.medico.controller;

import com.centro.integral.medico.repository.HistoriaClinicaRepository;
import com.centro.integral.medico.repository.entity.HistoriaClinica;
import com.centro.integral.medico.repository.entity.Paciente;
import com.centro.integral.medico.repository.entity.SignosVitales;
import com.centro.integral.medico.repository.entity.Tratamiento;
import com.centro.integral.medico.service.HistoriaClinicaService;
import com.centro.integral.medico.service.IHistoriaClinicaService;
import com.centro.integral.medico.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/historia-clinica")
@CrossOrigin
public class HistoriaClinicaController {
    @Autowired
    private IHistoriaClinicaService iHistoriaClinicaService;
    @Autowired
    private IPacienteService pacienteService;

    @PostMapping
    public ResponseEntity<HistoriaClinica> guardar(@RequestBody HistoriaClinica historiaClinica) {
        Optional<Paciente> paciente = this.pacienteService.obtener(historiaClinica.getPaciente().getCedula());
        if (paciente.isEmpty()) {
            this.pacienteService.insertar(historiaClinica.getPaciente());
            return ResponseEntity.of(this.iHistoriaClinicaService.insertar(historiaClinica));
        } else {
            // paciente.get().getHistoriaClinica();
            //historiaClinica.setPaciente(paciente.get());
            /*HistoriaClinica hc=paciente.get().getHistoriaClinica();
            hc.setExamenFisico(historiaClinica.getExamenFisico());
            hc.setEnfermedadActual(historiaClinica.getEnfermedadActual());
            hc.setDiagnosticoAlta(historiaClinica.getDiagnosticoAlta());
            hc.setDiagnosticoIngreso(historiaClinica.getDiagnosticoIngreso());*/
            //return ResponseEntity.of(this.iHistoriaClinicaService.insertar(hc));


        }
        return ResponseEntity.of(this.iHistoriaClinicaService.insertar(historiaClinica));

    }

    @GetMapping
    public ResponseEntity<List<HistoriaClinica>> listarTodo() {
        return ResponseEntity.of(this.iHistoriaClinicaService.getAll());

    }
}
