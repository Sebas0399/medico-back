package com.centro.integral.medico.controller;

import com.centro.integral.medico.repository.HistoriaClinicaRepository;
import com.centro.integral.medico.repository.entity.HistoriaClinica;
import com.centro.integral.medico.service.HistoriaClinicaService;
import com.centro.integral.medico.service.IHistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historia-clinica")
@CrossOrigin
public class HistoriaClinicaController {
    @Autowired
    private IHistoriaClinicaService iHistoriaClinicaService;
    @PostMapping
    public ResponseEntity<HistoriaClinica> guardar(@RequestBody HistoriaClinica historiaClinica){
       // System.out.println(historiaClinica);
        return ResponseEntity.of(this.iHistoriaClinicaService.insertar(historiaClinica));
    }
    @GetMapping
    public ResponseEntity<List<HistoriaClinica>> listarTodo(){
        return ResponseEntity.of(this.iHistoriaClinicaService.getAll());

    }
}
