package com.example.aula.service;

import com.example.aula.exception.PratoJaCadastradoException;
import com.example.aula.model.Restaurante;
import com.example.aula.repository.RestauranteRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class RestauranteService {
    private RestauranteRepository restauranteRepository;

    public RestauranteService(RestauranteRepository usuarioRepository) {
        this.restauranteRepository = usuarioRepository;
    }

    public List<Restaurante> listarTodos() {
        return restauranteRepository.findAll();
    }

    public Restaurante salvar(@Valid Restaurante prato) {
        if (restauranteRepository.findByPrato(prato.getPrato()).isPresent()) {
            throw new PratoJaCadastradoException("Prato já cadastrado.");
        }

        return restauranteRepository.save(prato);
    }


}
