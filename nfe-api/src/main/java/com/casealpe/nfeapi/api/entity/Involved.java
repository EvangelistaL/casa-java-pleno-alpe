package com.casealpe.nfeapi.api.entity;

import com.casealpe.nfeapi.api.model.InvolvedType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "involved")
public class Involved implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "identification_value")
    private String identificationValue;

    @NotBlank
    @Column(name = "identification_value")
    private String legalName;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "type")
    private InvolvedType type;
}
