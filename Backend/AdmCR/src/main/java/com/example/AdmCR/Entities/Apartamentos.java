/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.AdmCR.Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @Column(name="idApto")
    private Integer idApto;
    
    @Column(name="no_Apto")
    private String no_Apto; 
    
    @Column(name="no_Torre")
    private String no_Torre;    
    
}
