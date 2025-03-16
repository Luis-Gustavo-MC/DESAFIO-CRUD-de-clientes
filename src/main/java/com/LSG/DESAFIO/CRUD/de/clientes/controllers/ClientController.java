package com.LSG.DESAFIO.CRUD.de.clientes.controllers;

import com.LSG.DESAFIO.CRUD.de.clientes.DTO.ClientDTO;
import com.LSG.DESAFIO.CRUD.de.clientes.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    @Autowired
    ClientService service;

    @GetMapping(value = "/{id}")
    public ClientDTO findById(@PathVariable Long id){
        return service.findById(id);
    }
    @GetMapping()
    public Page<ClientDTO> findAll(Pageable pageable){
        Page<ClientDTO> dto = service.findAll(pageable);
        return dto;
    }
    @PostMapping()
    public void insert(@RequestBody ClientDTO dto){
        dto = service.insert(dto);
    }
    @PutMapping(value = "/{id}")
    public ClientDTO update(@RequestBody ClientDTO dto , @PathVariable Long id){
        dto = service.update(dto, id);
        return dto;
    }
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
