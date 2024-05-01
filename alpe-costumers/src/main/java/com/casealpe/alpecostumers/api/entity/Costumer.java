package com.casealpe.alpecostumers.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "costumer")
public class Costumer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "legal_name")
    private String legalName;

    @NotBlank
    @Column(name = "identification_value")
    private String identificationValue;
}
