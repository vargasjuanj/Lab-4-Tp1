package com.example.demo.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Noticia {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(unique=true, nullable = false)
    private String tituloDeLaNoticia;
    @Lob
    @Column(unique=true, nullable = false)
    private String resumenDeLaNoticia;
    @Column(unique=true, nullable = false)
    private String imagenNoticia;
    @Lob
    @Column(unique=true, nullable = false)
    private String contenidoHtml;
    @Column( nullable = false)
    private char publicada;
    @Temporal(TemporalType.DATE) //Mostrar fecha sin hora
    private Date fechaPublicacion;
    @ManyToOne() //relacionar con los ids de empresas ya creadas para crear una noticia con  fk a empresa. Las noticias seran independientes a las empresas, agregación..Muchoas a uno.
    @JoinColumn(name = "empresa.id")
    private Empresa empresa;
public Noticia(){

}


    public Noticia(int id, String tituloDeLaNoticia, String resumenDeLaNoticia, String imagenNoticia, String contenidoHtml, char publicada, Date fechaPublicacion, Empresa empresa) {
        this.id = id;
        this.tituloDeLaNoticia = tituloDeLaNoticia;
        this.resumenDeLaNoticia = resumenDeLaNoticia;
        this.imagenNoticia = imagenNoticia;
        this.contenidoHtml = contenidoHtml;
        this.publicada = publicada;
        this.fechaPublicacion = fechaPublicacion;
        this.empresa = empresa;
    }

    public String getTituloDeLaNoticia() {
        return tituloDeLaNoticia;
    }

    public void setTituloDeLaNoticia(String tituloDeLaNoticia) {
        this.tituloDeLaNoticia = tituloDeLaNoticia;
    }

    public String getResumenDeLaNoticia() {
        return resumenDeLaNoticia;
    }

    public void setResumenDeLaNoticia(String resumenDeLaNoticia) {
        this.resumenDeLaNoticia = resumenDeLaNoticia;
    }

    public String getImagenNoticia() {
        return imagenNoticia;
    }

    public void setImagenNoticia(String imagenNoticia) {
        this.imagenNoticia = imagenNoticia;
    }

    public String getContenidoHtml() {
        return contenidoHtml;
    }

    public void setContenidoHtml(String contenidoHtml) {
        this.contenidoHtml = contenidoHtml;
    }

    public char getPublicada() {
        return publicada;
    }

    public void setPublicada(char publicada) {
        this.publicada = publicada;
    }



    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Noticia)) return false;
        Noticia noticia = (Noticia) o;
        return getId() == noticia.getId() &&
                getPublicada() == noticia.getPublicada() &&
                Objects.equals(getTituloDeLaNoticia(), noticia.getTituloDeLaNoticia()) &&
                Objects.equals(getResumenDeLaNoticia(), noticia.getResumenDeLaNoticia()) &&
                Objects.equals(getImagenNoticia(), noticia.getImagenNoticia()) &&
                Objects.equals(getContenidoHtml(), noticia.getContenidoHtml()) &&
                Objects.equals(getFechaPublicacion(), noticia.getFechaPublicacion()) &&
                Objects.equals(getEmpresa(), noticia.getEmpresa());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTituloDeLaNoticia(), getResumenDeLaNoticia(), getImagenNoticia(), getContenidoHtml(), getPublicada(), getFechaPublicacion(), getEmpresa());
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "id=" + id +
                ", tituloDeLaNoticia='" + tituloDeLaNoticia + '\'' +
                ", resumenDeLaNoticia='" + resumenDeLaNoticia + '\'' +
                ", imagenNoticia='" + imagenNoticia + '\'' +
                ", contenidoHtml='" + contenidoHtml + '\'' +
                ", publicada=" + publicada +
                ", fechaPublicacion=" + fechaPublicacion +
                ", empresa=" + empresa +
                '}';
    }
}