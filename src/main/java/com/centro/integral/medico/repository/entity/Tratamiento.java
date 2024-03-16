package com.centro.integral.medico.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tratamiento")

public class Tratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    List<String> indicaciones;
    List<String> medicamento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "historia_clinica_id",nullable = false)
    @JsonBackReference // Anota en el inverso
    private HistoriaClinica historiaClinica;
}
