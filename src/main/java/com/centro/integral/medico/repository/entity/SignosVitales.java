package com.centro.integral.medico.repository.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "signos_vitales")

public class SignosVitales {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Integer id;
    private String pa;
    private String fc;
    private String rf;
    private Double temperatura;
    private Double peso;
    private Double talla;
    private Double so2;
    private String pc;
    @ManyToOne
    @JoinColumn(name = "historia_clinica_id")
    private HistoriaClinica historiaClinica;
}
