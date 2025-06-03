package com.example.aula.model;

public enum Categoria_Enum {
    ENTRADA("Entrada"),
    PRATO_PRINCIPAL("Prato Principal"),
    SOBREMESA("Sobremesa"),
    BEBIDA("Bebida");

    private String texto;

    Categoria_Enum(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
