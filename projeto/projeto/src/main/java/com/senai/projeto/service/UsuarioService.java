package com.senai.projeto.service;

import com.senai.projeto.dto.UsuarioDTO;
import com.senai.projeto.dto.UsuarioResponseDTO;
import com.senai.projeto.model.UsuarioEntity;
import com.senai.projeto.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsuarioService (UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UsuarioEntity salvarUsuario(UsuarioDTO dto){
        usuarioRepository.findByEmail(dto.getEmail())
                .ifPresent(u ->{throw new IllegalArgumentException("Email já cadastrado."); });

        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(bCryptPasswordEncoder.encode(dto.getSenha())); //criptografando a senha

        return usuarioRepository.save(usuario);
    }

    public List<UsuarioResponseDTO> listarTodosUsuarios(){
        return usuarioRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public UsuarioResponseDTO toDTO(UsuarioEntity usuario){
        return new UsuarioResponseDTO(usuario.getNome(), usuario.getEmail());
    }

    public UsuarioEntity atualizar(String email, UsuarioDTO dto){
        UsuarioEntity usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(bCryptPasswordEncoder.encode(dto.getSenha()));

        return usuarioRepository.save(usuario);
    }

    public void excluir(String email){
        UsuarioEntity usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("usuário não encontrado"));

        usuarioRepository.delete(usuario);
    }
}
