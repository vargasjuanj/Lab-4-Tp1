package com.example.demo.service;

import com.example.demo.entities.Empresa;
import com.example.demo.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaService extends ServicioGenerico<Empresa, EmpresaRepository>{
    @Override
    public Empresa update(int id, Empresa persona) throws Exception {

        try {
            Optional<Empresa> entityOptional = this.repository.findById((int) id);
            persona.setId(entityOptional.get().getId());
            persona = this.repository.save(persona);

            return persona;

        } catch (Exception e) {

            throw new Exception(e.getMessage());

        }

    }
}
