package com.example.demo.service;

import com.example.demo.entities.Noticia;
import com.example.demo.repository.NoticiaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticiaService extends ServicioGenerico<Noticia, NoticiaRepository> {

    public List<Noticia> findLatest(int id) throws Exception {
        try {
            return this.repository.getLatest(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
