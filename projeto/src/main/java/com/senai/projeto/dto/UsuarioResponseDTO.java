package com.senai.projeto.dto;

//o que vai aparecer no banco

public class UsuarioResponseDTO {
    private Long id;
    private String email;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
