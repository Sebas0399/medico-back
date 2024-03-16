package com.centro.integral.medico.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "diagnostico")

public class Diagnostico {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Integer id;
    private String ingreso;
    private String alta;
}
