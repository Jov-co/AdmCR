package com.example.AdmCR.Controller;

import com.example.AdmCR.Entities.Pagos;
import com.example.AdmCR.Services.PagosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/pagos")
public class PagosController {

    @Autowired
    private PagosServices services;

    @PostMapping(value = "/post")
    public ResponseEntity<Pagos> agregar(@RequestBody Pagos pagos){
        Pagos obj = services.save(pagos);
        if(obj != null) {
            return ResponseEntity.ok(obj);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Pagos> delete(@PathVariable Integer id){
        Pagos obj = services.findById(id);
        if(obj != null) {
            services.delete(id);
        }else {
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(obj);
    }

    @PutMapping("/edit")
    public ResponseEntity<Pagos> editar(@RequestBody Pagos pagos){
        Pagos obj = services.findById(pagos.getIdPagos());

        if (obj != null){
            obj.setIdPagos(pagos.getIdPagos());
            obj.setApartamentos(pagos.getApartamentos());
            obj.setEstado(pagos.getEstado());
            obj.setFecha(pagos.getFecha());
            obj.setValor(pagos.getValor());
            services.save(obj);
        }else{
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/list")
    public List<Pagos> consultarTodo(){
        return services.findAll();
    }
    @GetMapping("/list/{id}")
    public Pagos consultarId(@PathVariable Integer id){
        return services.findById(id);
    }
}
