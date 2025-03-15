package com.LSG.DESAFIO.CRUD.de.clientes.DTO;

import com.LSG.DESAFIO.CRUD.de.clientes.entities.Client;

public class ClientDTO {
    private String name;
    private String cpf;
    private Double income;
    private Integer children;

    public ClientDTO(Client entity){
        this.name =  entity.getName();
        this.income = entity.getIncome();
        this.cpf = entity.getCpf();
        this.children = entity.getChildren();
    }

    public ClientDTO() {
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public Integer getChildren() {
        return children;
    }
}
