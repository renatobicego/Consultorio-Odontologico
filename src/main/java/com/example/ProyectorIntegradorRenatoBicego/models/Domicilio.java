package com.example.ProyectorIntegradorRenatoBicego.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "domicilios")
@Getter
@Setter
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;


}
