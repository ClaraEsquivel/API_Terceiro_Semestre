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
    private String prato;

    @NotBlank(message = "A descição do produto é obrigatória.")
    private String descricao;

    @DecimalMin(value = "0.1", inclusive = true)
    @NotNull
    private double preco;

    @Enumerated(EnumType.STRING)
    private Categoria_Enum categoria;

    @Enumerated(EnumType.STRING)
    private Disponibilidade_Enum disponibilidade;

    @NotBlank(message = "O URL do prato é obrigatório")
    private String urlImagem;

    public Restaurante() {
    }

    public Restaurante(Long id, String prato, String descricao, double preco, Categoria_Enum categoria, Disponibilidade_Enum disponibilidade, String urlImagem) {
        this.id = id;
        this.prato = prato;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.disponibilidade = disponibilidade;
        this.urlImagem = urlImagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "O nome do prato é obrigatório.") String getPrato() {
        return prato;
    }

    public void setPrato(@NotBlank(message = "O nome do prato é obrigatório.") String prato) {
        this.prato = prato;
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

    public Categoria_Enum getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria_Enum categoria) {
        this.categoria = categoria;
    }

    public Disponibilidade_Enum getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade_Enum disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public @NotBlank(message = "O URL do prato é obrigatório") String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(@NotBlank(message = "O URL do prato é obrigatório") String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
