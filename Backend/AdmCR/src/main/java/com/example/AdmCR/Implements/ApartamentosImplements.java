/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.AdmCR.Implements;

import com.example.AdmCR.Entities.Apartamentos;
import com.example.AdmCR.Repository.ApartamentosRepository;
import com.example.AdmCR.Services.ApartamentosServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jbenavid
 */
@Service
public class ApartamentosImplements implements ApartamentosServices{
    
    @Autowired
    private ApartamentosRepository apartamentoRepository;

    @Override
    @Transactional(readOnly = false)
    public Apartamentos save(Apartamentos apartamentos) {
       return apartamentoRepository.save(apartamentos);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        apartamentoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Apartamentos findById(Integer id) {
        return apartamentoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Apartamentos> findAll() {
        return apartamentoRepository.findAll();
    }
    
    
}
