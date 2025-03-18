package com.LSG.DESAFIO.CRUD.de.clientes.DTO;

import com.LSG.DESAFIO.CRUD.de.clientes.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ClientDTO {

    @NotBlank(message = "Campo em branco" )@Size(min = 3 , max = 80, message = "Nome precisa ter entre 3 e 80 caracteres")
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
