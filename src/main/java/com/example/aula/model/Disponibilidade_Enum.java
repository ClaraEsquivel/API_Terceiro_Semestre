package com.example.aula.model;

public enum Disponibilidade_Enum {
    EM_ESTOQUE("Em estoque"),
    ESGOTADO("Esgotado");

    private String texto_disponibilidade;

    Disponibilidade_Enum(String texto_disponibilidade) {
        this.texto_disponibilidade = texto_disponibilidade;
    }

    public String getTexto_disponibilidade() {
        return texto_disponibilidade;
    }
}
