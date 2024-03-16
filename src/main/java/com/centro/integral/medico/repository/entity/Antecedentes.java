package com.centro.integral.medico.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
@Table(name = "antecedentes")

public class Antecedentes {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Integer id;
    private String app;
    private String apf;
    private String alergias;
    private String aqx;
    private String ago;
    @OneToOne(mappedBy = "antecedentes", fetch = FetchType.LAZY) // Add mappedBy

    @JoinColumn(name = "paciente_id")
    @JsonBackReference // Optional for one-to-one

    private Paciente paciente;

}
