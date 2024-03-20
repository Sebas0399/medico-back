package com.centro.integral.medico.controller;

import com.centro.integral.medico.repository.SignosVitalesRepository;
import com.centro.integral.medico.repository.entity.Paciente;
import com.centro.integral.medico.repository.entity.SignosVitales;
import com.centro.integral.medico.service.IPacienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/signos-vitales")
@CrossOrigin
public class SignosVitalesController {

    @Autowired
    private SignosVitalesRepository signosVitalesRepository;

    @PostMapping
    public ResponseEntity<SignosVitales> guardar(@RequestBody SignosVitales signosVitales) {
        this.signosVitalesRepository.save(signosVitales);
        return ResponseEntity.of(Optional.of(signosVitales));


    }


}
