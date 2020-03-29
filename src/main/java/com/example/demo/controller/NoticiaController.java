package com.example.demo.controller;

import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import com.example.demo.entities.Noticia;

import com.example.demo.service.NoticiaService;

import java.util.List;


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

    @GetMapping("/search")
    @Transactional
    public ResponseEntity<?> search(@RequestParam(value = "word") String palabras) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.service.findByWord(palabras));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\" : \"" + e.getMessage() + "\"}");
        }

    }

    @GetMapping("/paginas")
    public ResponseEntity<Page<Noticia>> paginas(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "7") int size,
            @RequestParam(defaultValue = "id") String order,
            @RequestParam(defaultValue = "true") boolean asc
    ){
        Page<Noticia> noticias = this.service.paginas(
                PageRequest.of(page, size, Sort.by(order)));
        if(!asc)
            noticias = this.service.paginas(
                    PageRequest.of(page, size, Sort.by(order).descending()));
        return new ResponseEntity<Page<Noticia>>(noticias, HttpStatus.OK);
    }
}
