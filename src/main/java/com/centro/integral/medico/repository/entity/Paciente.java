package com.centro.integral.medico.repository.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String cedula;
    private String primerNombre;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;
    private String numeroTelefono;
    private String parroquia;
    private String canton;
    private String provincia;
    private LocalDate fechaNacimiento;
    private String lugarNacimiento;
    private String nacionalidad;
    private String grupoCultural;
    private Integer edad;
    private String sexo;
    private String estadoCivil;
    private String instruccionEducativa;
    private LocalDate fechaAdmision;


    @OneToOne(cascade = CascadeType.ALL) // Remove mappedBy from here
    private SignosVitales signosVitales;

    @OneToOne(cascade = CascadeType.ALL) // Remove mappedBy from here
    @JsonManagedReference // Optional for one-to-one

    private Antecedentes antecedentes;

    @OneToOne(cascade = CascadeType.ALL)
    private HistoriaClinica historiaClinica;

}
