package com.LSG.DESAFIO.CRUD.de.clientes.DTO;

public class FieldMessage {
    private String fieldName;
    private String mensage;

    public FieldMessage(String fieldName, String mensage) {
        this.fieldName = fieldName;
        this.mensage = mensage;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMensage() {
        return mensage;
    }
}
