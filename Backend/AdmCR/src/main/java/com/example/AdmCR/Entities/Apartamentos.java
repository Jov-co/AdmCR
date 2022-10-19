/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.AdmCR.Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jbenavid
 */

@Entity
@Table(name="apartamentos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Apartamentos implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idApto", nullable = false)
    private Integer idApto;
    
    @Column(name="no_Apto", nullable = false)
    private String no_Apto; 
    
    @Column(name="no_Torre", nullable = false)
    private String no_Torre;

    @OneToMany(mappedBy = "apartamentos", cascade = CascadeType.ALL)
    private List<Pagos> pagos;

/*    @OneToMany(mappedBy = "apartamentos", cascade = CascadeType.ALL)
    private List<Usuarios> usuarios;*/
    
}
