package com.example.demo.repository;

import com.example.demo.entities.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepository extends JpaRepository<Noticia,Integer> {
}
