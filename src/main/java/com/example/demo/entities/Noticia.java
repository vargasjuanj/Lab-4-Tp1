package com.example.demo.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Noticia {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
  //  @Column(unique=true, nullable = false)
    private String tituloDeLaNoticia;
   @Lob
   // @Column(unique=true, nullable = false)

    private String resumenDeLaNoticia;
   // @Column(unique=true, nullable = false)
   @Lob
    private String imagenNoticia;
   @Lob
  //  @Column(unique=true, nullable = false)
    private String contenidoHtml;
  //  @Column( nullable = false)
    private char publicada;
   /*
    @Temporal(TemporalType.DATE) //Mostrar fecha sin hora
    private Date fechaPublicacion;
    */
   private String fechaPublicacion;
    @ManyToOne() //relacionar con los ids de empresas ya creadas para crear una noticia con  fk a empresa. Las noticias seran independientes a las empresas, agregación..Muchoas a uno.
    @JoinColumn(name = "empresa.id")
    private Empresa empresa;


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





}