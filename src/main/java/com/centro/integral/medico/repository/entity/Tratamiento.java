package com.centro.integral.medico.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tratamiento")

public class Tratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    List<String> indicaciones;
    List<String> medicamentos;
    @ManyToOne
    @JoinColumn(name = "historia_clinica_id")
    private HistoriaClinica historiaClinica;
}
