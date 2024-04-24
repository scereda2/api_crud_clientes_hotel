package com.example.demo.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "domicilios")
public class Domicilio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String calle;

    private String provincia;

    private  String localidad;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;


    public Domicilio() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }



    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad.toUpperCase();
    }


    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }


    public void setPais(Pais pais) {
        // Verificar si el país existe antes de establecer la relación
        if (pais == null || pais.getId() == null) {
            throw new IllegalArgumentException("El país es nulo o no tiene ID");
        }

        // Aquí puedes realizar una consulta a la base de datos o cualquier otra verificación para corroborar la existencia del país

        this.pais = pais;
    }

    public Pais getPais() {
        return pais;
    }
}
