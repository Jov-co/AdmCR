
package com.example.AdmCR.Services;

import com.example.AdmCR.Entities.Usuarios;
import java.util.List;

/**
 *
 * @author Zulay Angelica
 */
public interface UsuariosServices {

    public Usuarios save(Usuarios usuarios);

    public void delete(String id);

    public Usuarios findById(String id);

    public List<Usuarios> findAll();

}
