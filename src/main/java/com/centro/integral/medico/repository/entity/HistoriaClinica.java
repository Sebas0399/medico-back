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
    private String numHist;
    @OneToOne(fetch = FetchType.LAZY ,cascade = CascadeType.MERGE) // Add mappedBy
    @JoinColumn(name = "paciente_id")
    @JsonManagedReference

    private Paciente paciente;

    private String enfermedadActual;
    private String examenFisico;
    private String diagnosticoIngreso;
    private String diagnosticoAlta;
    @OneToMany(mappedBy = "historiaClinica")
    @JsonManagedReference
    private List<Tratamiento> tratamientos;


}
