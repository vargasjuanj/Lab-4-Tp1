package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.Empresa;

import com.example.demo.service.EmpresaService;



@RestController
@CrossOrigin(origins = "*",
        methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})



@RequestMapping(path = "api/v1/empresas")
public class EmpresaController extends ControllerGenerico<Empresa, EmpresaService>{


}
