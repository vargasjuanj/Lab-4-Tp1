package com.example.demo.service;


import com.example.demo.entities.Noticia;
import com.example.demo.repository.EmpresaRepository;
import com.example.demo.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoticiaService extends ServicioGenerico<Noticia, NoticiaRepository> {
    @Autowired
    private NoticiaRepository repositoryNoticias;
    @Autowired
    private EmpresaRepository repositoryEmpresas;


    public Page<Noticia> paginas(Pageable pageable){
        return repositoryNoticias.findAll(pageable);
    }
    @Override
    public Noticia update(long id, Noticia noticia) throws Exception {

        try {
            Optional<Noticia> entityOptional = repositoryNoticias.findById(id);
            noticia.setId(entityOptional.get().getId());
/*
try {
    Optional<Noticia> noticiaOptional = repositoryEmpresas.findById((long) noticia.getNoticia().getId());
    Noticia noticia = noticiaOptional.get();
    noticia.addNoticia(noticia);
    repositoryEmpresas.save(noticia);
    noticia.setNoticia(noticia);
}catch(Exception e){}
*/

            noticia = repositoryNoticias.save(noticia);
            return noticia;

        } catch (Exception e) {

            throw new Exception(e.getMessage());

        }

    }

}

    /*
        @Override
        public Noticia save(Noticia noticia) throws Exception {
            try {

                Optional<Noticia> entityOptional = repositoryEmpresas.findById((long) noticia.getNoticia().getId());

                Noticia noticia = entityOptional.get();
                noticia.addNoticia(noticia);
               repositoryEmpresas.save(noticia);
    noticia.setNoticia(noticia);
                noticia= repositoryNoticias.save(noticia);

                return noticia;

            } catch (Exception e) {

                throw new Exception(e.getMessage());

            }
        }

    */
