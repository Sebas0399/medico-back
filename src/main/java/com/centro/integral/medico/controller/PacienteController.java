package com.centro.integral.medico.controller;

import com.centro.integral.medico.repository.entity.Paciente;
import com.centro.integral.medico.service.IPacienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin
public class PacienteController {
    @Autowired
    private IPacienteService pacienteService;


    @GetMapping("/{cedula}")
    public Optional<Paciente> obtener(@PathVariable String cedula) {
        return pacienteService.obtener(cedula);
    }

    @GetMapping("id/{id}")
    public Optional<Paciente> obtenerPorId(@PathVariable Integer id) {
        return pacienteService.obtener(id);
    }

    @GetMapping("nombre/{nombre}")
    public Optional<List<Paciente>> obtenerPorNombre(@PathVariable String nombre) {
        return pacienteService.obtenerPorNombre(nombre);
    }

    @PostMapping
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente) {
        Optional<Paciente> pacienteEncontrado = this.pacienteService.obtener(paciente.getCedula());
        if (pacienteEncontrado.isEmpty()) {
            return ResponseEntity.of(this.pacienteService.insertar(paciente));
        } else {
            BeanUtils.copyProperties(paciente, pacienteEncontrado.get(), "id");
            return ResponseEntity.of(this.pacienteService.insertar(pacienteEncontrado.get()));


        }

    }


}
