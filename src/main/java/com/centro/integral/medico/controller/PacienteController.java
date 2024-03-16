package com.centro.integral.medico.controller;

import com.centro.integral.medico.repository.entity.Paciente;
import com.centro.integral.medico.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin
public class PacienteController {
    @Autowired
    private IPacienteService pacienteService;

    @PostMapping
    public Optional<Paciente> insertar(@RequestBody Paciente paciente) {
        return pacienteService.insertar(paciente);
    }

    @GetMapping("/{cedula}")
    public Optional<Paciente> obtener(@PathVariable String cedula) {

        return pacienteService.obtener(cedula);
    }


}
