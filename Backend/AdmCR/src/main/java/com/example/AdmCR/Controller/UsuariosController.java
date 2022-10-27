
package com.example.AdmCR.Controller;

import com.example.AdmCR.Entities.Apartamentos;
import com.example.AdmCR.Entities.Usuarios;
import com.example.AdmCR.Services.ApartamentosServices;
import com.example.AdmCR.Services.UsuariosServices;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Zulay Angelica
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuariosController {

    @Autowired
    private UsuariosServices usuariosServices;
    @Autowired
    private ApartamentosServices apartamentosServices;

    @PostMapping(value = "/post")
    public ResponseEntity<Usuarios> agregar(@RequestBody Usuarios usuarios) {
        Apartamentos apt = usuarios.getApartamentos();
        apt.setIdApto(Integer.valueOf(apt.getNo_Apto() + apt.getNo_Torre()));
        usuarios.setApartamentos(apt);
        apartamentosServices.save(apt);
        Usuarios obj = usuariosServices.save(usuarios);
        if (obj != null) {
            return ResponseEntity.ok(obj);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Usuarios> eliminar(@PathVariable String id) {
        Usuarios obj = usuariosServices.findById(id);
        if (obj != null) {
            usuariosServices.delete(id);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(obj);
    }

    @PutMapping("/edit")
    public ResponseEntity<Usuarios> editar(@RequestBody Usuarios usuarios) {
        Usuarios obj = usuariosServices.findById(usuarios.getIdUsuario());

        if (obj != null) {
            obj.setIdUsuario(usuarios.getIdUsuario());
            obj.setNombre(usuarios.getNombre());
            obj.setApellidos(usuarios.getApellidos());
            obj.setTelefono(usuarios.getTelefono());
            obj.setEmail(usuarios.getEmail());
            obj.setApartamentos(usuarios.getApartamentos());

            usuariosServices.save(obj);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/list")
    public List<Usuarios> consultarTodo() {
        return usuariosServices.findAll();
    }

    @GetMapping("/list/{id}")
    public Usuarios consultarId(@PathVariable String id) {
        return usuariosServices.findById(id);
    }

}
