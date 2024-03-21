package com.centro.integral.medico.controller;

import com.centro.integral.medico.repository.entity.HistoriaClinica;
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
    @GetMapping("nombre/{nombre}")
    public Optional<List<Paciente>> obtenerPorNombre(@PathVariable String nombre) {

        return pacienteService.obtenerPorNombre(nombre);
    }

    @PostMapping
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente) {
        Optional<Paciente> pacienteEncontrado = this.pacienteService.obtener(paciente.getCedula());
        if (pacienteEncontrado.isEmpty()) {
            System.out.println("Nuevo");

            return ResponseEntity.of(this.pacienteService.insertar(paciente));
        } else {
            System.out.println("Actualizar");
            System.out.println(paciente);

            BeanUtils.copyProperties(paciente, pacienteEncontrado.get(),"id");
            System.out.println(pacienteEncontrado);

            return ResponseEntity.of(this.pacienteService.insertar(pacienteEncontrado.get()));


        }

    }


}
