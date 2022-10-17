/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.AdmCR.Services;

import com.example.AdmCR.Entities.Apartamentos;
import java.util.List;

/**
 *
 * @author jbenavid
 */
public interface ApartamentosServices {

    public Apartamentos save(Apartamentos apartamentos);

    public void delete(Integer id);

    public Apartamentos findById(Integer id);

    public List<Apartamentos> findAll();
}
