package com.LSG.DESAFIO.CRUD.de.clientes.controllers;

import com.LSG.DESAFIO.CRUD.de.clientes.DTO.ClientDTO;
import com.LSG.DESAFIO.CRUD.de.clientes.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/client")
public class ClientController {
    @Autowired
    ClientService service;

    @GetMapping(value = "/{id}")
    public ClientDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

}
