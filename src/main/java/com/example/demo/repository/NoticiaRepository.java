package com.example.demo.repository;

import com.example.demo.entities.Empresa;
import com.example.demo.entities.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoticiaRepository extends JpaRepository<Noticia,Integer> {
    @Query(value = "SELECT * FROM noticia WHERE empresa_id= :id ORDER BY fecha_publicacion DESC LIMIT 5", nativeQuery = true)
    public List<Noticia> getLatest(@Param("id") int id);

    @Query(value = "SELECT * FROM noticia WHERE titulo_de_la_noticia LIKE %?1% OR resumen_de_la_noticia LIKE %?1% ORDER BY fecha_publicacion LIMIT 20", nativeQuery = true)
    public List<Noticia> getByWords(String palabra);
}
