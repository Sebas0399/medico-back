package com.centro.integral.medico.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Integer id;
    @Column(unique = true)
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
    //
    private LocalDate fechaAdmision;
    private String ocupacion;
    private String empresaTrabajo;
    private String tipoSeguro;
    private String referido;
    //
    private String contactoEmergenciaNombre;
    private String contactoEmergenciaAfinidad;
    private String contactoEmergenciaDireccion;
    private String contactoEmergenciaTelefono;

    //
    private String llegadaForma;
    private String llegadaFuente;
    private String llegadaEntrega;
    private String llegadaTelefono;

    //Antecedentes
    private String app;
    private String apf;
    private String alergias;
    private String aqx;
    private String ago;

    //

    @OneToMany(mappedBy = "paciente")
    @JsonManagedReference

    private List<HistoriaClinica> historiasClinicas;

}
