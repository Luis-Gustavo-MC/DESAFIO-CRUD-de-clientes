package com.LSG.DESAFIO.CRUD.de.clientes.controllers;

import com.LSG.DESAFIO.CRUD.de.clientes.DTO.ClientDTO;
import com.LSG.DESAFIO.CRUD.de.clientes.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    @Autowired
    ClientService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO>  findById(@PathVariable Long id){
        return  ResponseEntity.ok(service.findById(id));
    }

    @GetMapping()
    public ResponseEntity<Page<ClientDTO>>  findAll(Pageable pageable){
        Page<ClientDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }
    @PostMapping()
    public ResponseEntity<ClientDTO> insert(@Valid @RequestBody ClientDTO dto){
        dto = service.insert(dto);
        return ResponseEntity.ok(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTO>  update(@Valid @RequestBody ClientDTO dto , @PathVariable Long id){
        dto = service.update(dto, id);
        return ResponseEntity.ok(dto) ;
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
