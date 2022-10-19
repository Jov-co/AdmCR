package com.example.AdmCR.Services;

import com.example.AdmCR.Entities.Pagos;

import java.util.List;

public interface PagosServices {
    public Pagos save(Pagos pagos);

    public void delete(Integer id);

    public Pagos findById(Integer id);

    public List<Pagos> findAll();
}
