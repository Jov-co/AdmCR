
package com.example.AdmCR.Implements;

import com.example.AdmCR.Entities.Usuarios;
import com.example.AdmCR.Repository.UsuariosRepository;
import com.example.AdmCR.Services.UsuariosServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay Angelica
 */
@Service
public class UsuariosImplements implements UsuariosServices {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    @Transactional(readOnly = false)
    public Usuarios save(Usuarios usuarios) {
        return usuariosRepository.save(usuarios);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(String id) {
        usuariosRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios findById(String id) {
        return usuariosRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> findAll() {
        return usuariosRepository.findAll();
    }

}
