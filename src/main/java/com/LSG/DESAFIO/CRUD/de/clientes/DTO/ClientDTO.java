package com.LSG.DESAFIO.CRUD.de.clientes.DTO;

import com.LSG.DESAFIO.CRUD.de.clientes.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ClientDTO {

    @NotBlank(message = "Tem que ter alguma coisa")
    private String name;
    private String cpf;
    private Double income;
    private Integer children;
    @PastOrPresent
    private LocalDate birthDate;

    public ClientDTO(Client entity){
        this.name =  entity.getName();
        this.income = entity.getIncome();
        this.cpf = entity.getCpf();
        this.children = entity.getChildren();
        this.birthDate = entity.getBirthDate();
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

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
