package com.example.demo.service;

import com.example.demo.entities.Empresa;
import com.example.demo.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaService extends ServicioGenerico<Empresa, EmpresaRepository> {
    @Autowired
    private EmpresaRepository repository;


    @Override
    public Empresa save(Empresa entityForm) throws Exception {
        try {

            entityForm = repository.save(entityForm);

            return entityForm;

        } catch (Exception e) {

            throw new Exception(e.getMessage());

        }
    }

    @Override
    public Empresa update(long id, Empresa persona) throws Exception {

        try {
            Optional<Empresa> entityOptional = this.repository.findById((long) id);
            persona.setId(entityOptional.get().getId());
            persona = repository.save(persona);

            return persona;

        } catch (Exception e) {

            throw new Exception(e.getMessage());

        }

    }


}
