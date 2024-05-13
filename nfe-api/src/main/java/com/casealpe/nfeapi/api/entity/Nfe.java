package com.casealpe.nfeapi.api.entity;

import com.casealpe.nfeapi.api.model.NfeStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "nfe")
public class Nfe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "numero_nfe")
    private String nfeNumber;

    @NotNull
    @Column(name = "value")
    private BigDecimal value;

    @NotNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private NfeStatus status;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "nfe_id")
    private Set<Boleto> boletos;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST},
            mappedBy = "nfe")
    private List<Involved> involveds;
}
