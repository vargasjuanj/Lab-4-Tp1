package com.example.demo.controller;

import com.example.demo.entities.Noticia;
import com.example.demo.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})


@RequestMapping(path = "api/v1/noticias")
public class NoticiaController extends ControllerGenerico<Noticia, NoticiaService> {
@Autowired
private NoticiaService noticiaService;
    @GetMapping("/paginas")
    public ResponseEntity<Page<Noticia>> paginas(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(defaultValue = "tituloDelaNoticia") String order,
            @RequestParam(defaultValue = "true") boolean asc
    ){
        Page<Noticia> noticias = noticiaService.paginas(
                PageRequest.of(page, size, Sort.by(order)));
        if(!asc)
            noticias = noticiaService.paginas(
                    PageRequest.of(page, size, Sort.by(order).descending()));
        return new ResponseEntity<Page<Noticia>>(noticias, HttpStatus.OK);
    }
}
