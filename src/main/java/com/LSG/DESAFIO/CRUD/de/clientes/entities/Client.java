package com.LSG.DESAFIO.CRUD.de.clientes.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String cpf;
    private Double income;
    private Integer children;

    public Long getId() {
        return id;
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

    public Client(Long id, String name, String cpf, Double income, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.children = children;
    }

    public Client() {
    }
}
