package com.example.demo.entities;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //Se obvio name length dentro de Column
   // @Column(unique=true, nullable = false)
    private String denominacion;
   // @Column(unique=true, nullable = false)
    private String telefono;
   // @Column(nullable=false)
    private String horarioDeAtencion;
   @Lob //Para cadenas mayores a 256
  //  @Column(nullable=false)
    private String quienesSomos;

    private float latitud;

    private float longitud;
  //  @Column(unique=true, nullable = false)
    private String domicilio;

   // @Column(unique=true, nullable = false)
    private String email;

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getHorarioDeAtencion() {
        return horarioDeAtencion;
    }

    public void setHorarioDeAtencion(String horarioDeAtencion) {
        this.horarioDeAtencion = horarioDeAtencion;
    }

    public String getQuienesSomos() {
        return quienesSomos;
    }

    public void setQuienesSomos(String quienesSomos) {
        this.quienesSomos = quienesSomos;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}