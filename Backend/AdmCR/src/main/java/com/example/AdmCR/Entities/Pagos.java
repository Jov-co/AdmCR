package com.example.AdmCR.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pagos")
public class Pagos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPagos;

    @Column(name="fecha", nullable = false)
    private LocalDate fecha;

    @Column(name="estado", nullable = false)
    private Boolean estado;

    @Column(name="valor", nullable = false)
    private Double valor;

    @ManyToOne
    @JoinColumn(name="fk_ref_apto", nullable = false)
    private Apartamentos apartamentos;
}
