package com.example.AdmCR.Controller;

import com.example.AdmCR.Entities.Apartamentos;
import com.example.AdmCR.Services.ApartamentosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/apartamentos")
public class ApartamentosController {

    @Autowired
    private ApartamentosServices apartamentosServices;

    @PostMapping(value = "/post")
    public ResponseEntity<Apartamentos> agregar(@RequestBody Apartamentos apartamentos){
        Apartamentos obj = apartamentosServices.save(apartamentos);
        if (obj != null)
            return ResponseEntity.ok(obj);
        else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Apartamentos> eliminar(@PathVariable Integer id){
        Apartamentos obj = apartamentosServices.findById(id);
        if (obj != null){
            apartamentosServices.delete(id);
        }
        else{
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(obj);
    }

    @PutMapping("/edit")
    public ResponseEntity<Apartamentos> editar(@RequestBody Apartamentos apartamentos){
        Apartamentos obj = apartamentosServices.findById(apartamentos.getIdApto());

        if (obj != null){
            obj.setIdApto(apartamentos.getIdApto());
            obj.setNo_Apto(apartamentos.getNo_Apto());
            obj.setNo_Torre(apartamentos.getNo_Torre());
            apartamentosServices.save(obj);
        }
        else{
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/list")
    public List<Apartamentos> consultarTodo (){
        return apartamentosServices.findAll();
    }

    @GetMapping("/list/{id}")
    public Apartamentos consultarId(@PathVariable Integer id){
        return apartamentosServices.findById(id);

    }

}
