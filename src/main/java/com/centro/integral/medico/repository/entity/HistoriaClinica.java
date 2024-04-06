package com.centro.integral.medico.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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

    private LocalDate fecha;

    private List<String> indicaciones;
    private List<String> medicamento;

    //
    @JdbcTypeCode(SqlTypes.JSON)
    private List<Map<String, String>> examenes;
}
