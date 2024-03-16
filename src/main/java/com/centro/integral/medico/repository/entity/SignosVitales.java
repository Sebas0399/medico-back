package com.centro.integral.medico.repository.entity;

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
    @OneToOne(mappedBy = "signosVitales", fetch = FetchType.LAZY) // Add mappedBy
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
}
