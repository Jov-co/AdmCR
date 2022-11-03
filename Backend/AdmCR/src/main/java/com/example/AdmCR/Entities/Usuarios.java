package com.example.AdmCR.Entities;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Zulay Angelica
 */

@Entity
@Table(name="usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Usuarios implements Serializable{

    @Id
    @Column(name = "idUsuario")
    private String idUsuario;

    @Column ( name = "nombre", nullable = false)
    private String nombre;

    @Column (name = "apellidos", nullable = false)
    private String apellidos;

    @Column (name = "telefono", nullable = false)
    private String telefono;

    @Column (name = "email", nullable = false)
    private String email;

    @ManyToOne(targetEntity = Apartamentos.class, cascade = CascadeType.ALL)
    @JoinColumn(name="ref_apartamento",referencedColumnName = "id_apto" , nullable = false)
    private Apartamentos apartamentos;


}