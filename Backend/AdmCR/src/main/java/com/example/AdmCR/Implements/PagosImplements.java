package com.example.AdmCR.Implements;

import com.example.AdmCR.Entities.Pagos;
import com.example.AdmCR.Repository.PagosRepository;
import com.example.AdmCR.Services.PagosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Jov_co
 */

@Service
public class PagosImplements implements PagosServices {

    @Autowired
    private PagosRepository pagosRepository;

    @Override
    @Transactional(readOnly = false)
    public Pagos save(Pagos pagos) {
        return pagosRepository.save(pagos);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        pagosRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Pagos findById(Integer id) {
        return pagosRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pagos> findAll() {
        return pagosRepository.findAll();
    }
}
