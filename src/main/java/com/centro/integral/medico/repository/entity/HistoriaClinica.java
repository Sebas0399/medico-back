package com.centro.integral.medico.repository.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "historia_clinica")
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    //@GeneratedValue(strategy = GenerationType.AUTO)

    private String numHist;

    @OneToOne(fetch = FetchType.LAZY) // Add mappedBy
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private String enfermedadActual;
    private String examenFisico;
    private String diagnosticoIngreso;
    private String diagnosticoAlta;
    @OneToMany(mappedBy = "historiaClinica")
    @JsonManagedReference

    private List<Tratamiento> tratamientos;


}
