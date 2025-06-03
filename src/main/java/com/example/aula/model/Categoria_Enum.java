package com.example.aula.model;

public enum Categoria_Enum {
    ENTRADA("Entrada"),
    PRATO_PRINCIPAL("Prato Principal"),
    SOBREMESA("Sobremesa"),
    BEBIDA("Bebida");

    private String texto_categoria;

    Categoria_Enum(String texto_categoria) {
        this.texto_categoria = texto_categoria;
    }

    public String getTexto_categoria() {
        return texto_categoria;
    }
}
