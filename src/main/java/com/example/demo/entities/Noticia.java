package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "noticias")
public class Noticia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
            (strategy = GenerationType.IDENTITY)
    private long id;
   // @Column(unique = true, nullable = false)
    private String tituloDeLaNoticia;
  //  @Lob
  //  @Column(unique = true, nullable = false)
    private String resumenDeLaNoticia;
  //  @Column(unique = true, nullable = false)
    private String imagenNoticia;
  //  @Lob
   // @Column(unique = true, nullable = false)
    private String contenidoHtml;
   // @Column(nullable = false)
    private char publicada;
    private String fechaPublicacion;
    /*
    @Temporal(TemporalType.TIMESTAMP)
    //Mostrar fecha sin hora con DATE, hora con TIME y feche y hora con TIMESTAMP cuando se crea un objeto
    private Date fechaPublicacion;

     */
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "noticias",})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
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

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
/*
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    */

}

