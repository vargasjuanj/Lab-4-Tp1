package com.example.demo.controller;

import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import com.example.demo.entities.Noticia;

import com.example.demo.service.NoticiaService;


@RestController
@CrossOrigin(origins = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})


@RequestMapping(path = "api/v1/noticia")
public class NoticiaController extends ControllerGenerico<Noticia, NoticiaService> {

    @GetMapping("/recent")
    @Transactional
    public ResponseEntity<?> getLatest(@RequestParam(value = "idEmpresa", defaultValue = "-1") int idEmpresa) {
        try {
            if (idEmpresa < 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"wrong parameters\"}");
            } else {

                return ResponseEntity.status(HttpStatus.OK).body(this.service.findLatest(idEmpresa));
            }
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.getMessage() + "\"}");

        }

    }

}
