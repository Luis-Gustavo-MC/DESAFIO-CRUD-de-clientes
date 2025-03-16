package com.LSG.DESAFIO.CRUD.de.clientes.services;

import com.LSG.DESAFIO.CRUD.de.clientes.DTO.ClientDTO;
import com.LSG.DESAFIO.CRUD.de.clientes.entities.Client;
import com.LSG.DESAFIO.CRUD.de.clientes.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClientService {
    @Autowired
    ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client = repository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Recurso não encontrado"));
        return new ClientDTO(client);
    }
    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
        Page<Client> clients =  repository.findAll(pageable);
        return clients.map(ClientDTO::new);
    }
    @Transactional
    public ClientDTO insert(ClientDTO dto){
        Client client = new Client();

        client.setName(dto.getName());
        client.setChildren(dto.getChildren());
        client.setCpf(dto.getCpf());
        client.setIncome(dto.getIncome());
        client.setBirthDate(dto.getBirthDate());

        client = repository.save(client);

        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(ClientDTO dto , Long id){
        Client client = repository.getReferenceById(id);

        client.setName(dto.getName());
        client.setChildren(dto.getChildren());
        client.setCpf(dto.getCpf());
        client.setIncome(dto.getIncome());
        client.setBirthDate(dto.getBirthDate());

        repository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }
}
