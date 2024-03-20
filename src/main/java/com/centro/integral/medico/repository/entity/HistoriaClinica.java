package com.centro.integral.medico.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Data
@Entity
@Table(name = "historia_clinica")
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String numHist;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "paciente_id")
    @JsonBackReference
    private Paciente paciente;

    private String enfermedadActual;
    private String examenFisico;
    private String diagnosticoIngreso;
    private String diagnosticoAlta;



}
