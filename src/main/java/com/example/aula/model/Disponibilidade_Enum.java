package com.example.aula.model;

public enum Disponibilidade_Enum {
    EM_ESTOQUE("Em estoque"),
    ESGOTADO("Esgotado");

    private String texto;

    Disponibilidade_Enum(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
