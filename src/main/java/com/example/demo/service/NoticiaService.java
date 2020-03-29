package com.example.demo.service;

import com.example.demo.entities.Noticia;
import com.example.demo.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoticiaService extends ServicioGenerico<Noticia, NoticiaRepository> {

    public List<Noticia> findLatest(int id) throws Exception {
        try {
            return this.repository.getLatest(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Noticia> findByWord(String palabras) throws  Exception{
        try {
            return this.repository.getByWords(palabras);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }



    public Page<Noticia> paginas(Pageable pageable){
        return  this.repository.findAll(pageable);
    }
    @Override
    public Noticia update(int id, Noticia noticia) throws Exception {

        try {
            Optional<Noticia> entityOptional = this.repository.findById(id);
            noticia.setId(entityOptional.get().getId());

            noticia = this.repository.save(noticia);
            return noticia;

        } catch (Exception e) {

            throw new Exception(e.getMessage());

        }

    }

}


