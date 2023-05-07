package com.example.ProyectorIntegradorRenatoBicego.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Entity
@Table(name = "pacientes")
@Getter
@Setter
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String apellido;
    private String nombre;
    private String email;
    private Integer dni;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate fechaIngreso;
    @OneToOne
    @JoinColumn(name="domicilio_id", referencedColumnName = "id")
    private Domicilio domicilio;

}
