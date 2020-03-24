package com.example.demo.entities;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //Se obvio name length dentro de Column
    @Column(unique=true, nullable = false)
    private String denominacion;
    @Column(unique=true, nullable = false)
    private String telefono;
    @Column(nullable=false)
    private String horarioDeAtencion;
    @Lob //Para cadenas mayores a 256
    @Column(nullable=false)
    private String quienesSomos;

    private float latitud;

    private float longitud;
    @Column(unique=true, nullable = false)
    private String domicilio;

    @Column(unique=true, nullable = false)
    private String email;

    public Empresa() {
    }

    public Empresa(int id, String denominacion, String telefono, String horarioDeAtencion, String quienesSomos, float latitud, float longitud, String domicilio, String email) {
        this.id = id;
        this.denominacion = denominacion;
        this.telefono = telefono;
        this.horarioDeAtencion = horarioDeAtencion;
        this.quienesSomos = quienesSomos;
        this.latitud = latitud;
        this.longitud = longitud;
        this.domicilio = domicilio;
        this.email = email;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empresa)) return false;
        Empresa empresa = (Empresa) o;
        return getId() == empresa.getId() &&
                Float.compare(empresa.getLatitud(), getLatitud()) == 0 &&
                Float.compare(empresa.getLongitud(), getLongitud()) == 0 &&
                Objects.equals(getDenominacion(), empresa.getDenominacion()) &&
                Objects.equals(getTelefono(), empresa.getTelefono()) &&
                Objects.equals(getHorarioDeAtencion(), empresa.getHorarioDeAtencion()) &&
                Objects.equals(getQuienesSomos(), empresa.getQuienesSomos()) &&
                Objects.equals(getDomicilio(), empresa.getDomicilio()) &&
                Objects.equals(getEmail(), empresa.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDenominacion(), getTelefono(), getHorarioDeAtencion(), getQuienesSomos(), getLatitud(), getLongitud(), getDomicilio(), getEmail());
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", denominacion='" + denominacion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", horarioDeAtencion='" + horarioDeAtencion + '\'' +
                ", quienesSomos='" + quienesSomos + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", domicilio='" + domicilio + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}