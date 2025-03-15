package com.LSG.DESAFIO.CRUD.de.clientes.repositories;

import com.LSG.DESAFIO.CRUD.de.clientes.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
