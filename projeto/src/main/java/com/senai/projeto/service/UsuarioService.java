package com.senai.projeto.service;

import com.senai.projeto.dto.UsuarioDTO;
import com.senai.projeto.model.UsuarioEntity;
import com.senai.projeto.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public UsuarioService (UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioEntity salvarUsuario(UsuarioDTO dto){
        if (usuarioRepository.findByEmail(dto.getEmail()).isPresent()){
            throw new IllegalArgumentException("Email já cadastrado.");
        }

        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(passwordEncoder.encode(dto.getSenha())); //criptografando a senha

        return usuarioRepository.save(usuario);
    }

    public List<UsuarioEntity> listarTodosUsuarios(){
        return usuarioRepository.findAll();
    }
}
