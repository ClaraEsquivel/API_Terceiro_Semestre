package com.example.aula.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "tab_prato")
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do prato é obrigatório.")
    private String nome_prato;

    @NotBlank(message = "A descição do produto é obrigatória.")
    private String descricao;

    @DecimalMin(value = "0.1", inclusive = true)
    @NotNull
    private double preco;

    @Enumerated(EnumType.STRING)
    private Categoria_Enum texto_categoria;

    @Enumerated(EnumType.STRING)
    private Disponibilidade_Enum texto_disponibilidade;

    @NotBlank(message = "O URL do prato é obrigatório")
    private String urlImagem;

    public Restaurante() {
    }

    public Restaurante(Long id, String nome_prato, String descricao, double preco, Categoria_Enum texto_categoria, Disponibilidade_Enum texto_disponibilidade, String urlImagem) {
        this.id = id;
        this.nome_prato = nome_prato;
        this.descricao = descricao;
        this.preco = preco;
        this.texto_categoria = texto_categoria;
        this.texto_disponibilidade = texto_disponibilidade;
        this.urlImagem = urlImagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "O nome do prato é obrigatório.") String getNome_prato() {
        return nome_prato;
    }

    public void setNome_prato(@NotBlank(message = "O nome do prato é obrigatório.") String nome_prato) {
        this.nome_prato = nome_prato;
    }

    public @NotBlank(message = "A descição do produto é obrigatória.") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank(message = "A descição do produto é obrigatória.") String descricao) {
        this.descricao = descricao;
    }

    @DecimalMin(value = "0.1", inclusive = true)
    @NotNull
    public double getPreco() {
        return preco;
    }

    public void setPreco(@DecimalMin(value = "0.1", inclusive = true) @NotNull double preco) {
        this.preco = preco;
    }

    public Categoria_Enum getTexto_categoria() {
        return texto_categoria;
    }

    public void setTexto_categoria(Categoria_Enum texto_categoria) {
        this.texto_categoria = texto_categoria;
    }

    public Disponibilidade_Enum getTexto_disponibilidade() {
        return texto_disponibilidade;
    }

    public void setTexto_disponibilidade(Disponibilidade_Enum texto_disponibilidade) {
        this.texto_disponibilidade = texto_disponibilidade;
    }

    public @NotBlank(message = "O URL do prato é obrigatório") String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(@NotBlank(message = "O URL do prato é obrigatório") String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
