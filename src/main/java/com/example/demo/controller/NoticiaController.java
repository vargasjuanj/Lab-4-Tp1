package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.Noticia;

import com.example.demo.service.NoticiaService;



@RestController
@CrossOrigin(origins = "*",
        methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})



@RequestMapping(path = "api/v1/noticia")
public class NoticiaController extends ControllerGenerico<Noticia, NoticiaService>{


}
