package com.example.demo.service;


import com.example.demo.entities.Noticia;
import com.example.demo.repository.EmpresaRepository;
import com.example.demo.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoticiaService extends ServicioGenerico<Noticia, NoticiaRepository> {
    @Autowired
    private NoticiaRepository repositoryDom;
    @Autowired
    private EmpresaRepository repositoryPer;

    @Override
    public Noticia update(long id, Noticia domicilio) throws Exception {

        try {
            Optional<Noticia> entityOptional = repositoryDom.findById(id);
            domicilio.setId(entityOptional.get().getId());
/*
try {
    Optional<Persona> personaOptional = repositoryPer.findById((long) domicilio.getPersona().getId());
    Persona persona = personaOptional.get();
    persona.addNoticia(domicilio);
    repositoryPer.save(persona);
    domicilio.setPersona(persona);
}catch(Exception e){}
*/

            domicilio = repositoryDom.save(domicilio);
            return domicilio;

        } catch (Exception e) {

            throw new Exception(e.getMessage());

        }

    }

}

    /*
        @Override
        public Noticia save(Noticia domicilio) throws Exception {
            try {

                Optional<Persona> entityOptional = repositoryPer.findById((long) domicilio.getPersona().getId());

                Persona persona = entityOptional.get();
                persona.addNoticia(domicilio);
               repositoryPer.save(persona);
    domicilio.setPersona(persona);
                domicilio= repositoryDom.save(domicilio);

                return domicilio;

            } catch (Exception e) {

                throw new Exception(e.getMessage());

            }
        }

    */
