package com.LSG.DESAFIO.CRUD.de.clientes.services;

import com.LSG.DESAFIO.CRUD.de.clientes.DTO.ClientDTO;
import com.LSG.DESAFIO.CRUD.de.clientes.entities.Client;
import com.LSG.DESAFIO.CRUD.de.clientes.repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        try {
            Client client = repository.getReferenceById(id);

            client.setName(dto.getName());
            client.setChildren(dto.getChildren());
            client.setCpf(dto.getCpf());
            client.setIncome(dto.getIncome());
            client.setBirthDate(dto.getBirthDate());

            repository.save(client);
            return new ClientDTO(client);
        }catch (EntityNotFoundException e ){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional
    public void delete(Long id){
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try{
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e ){
            throw new DatabaseException("Falha de integridade referencial");
        }

    }
}
