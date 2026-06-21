package com.foodsaver.service;

import com.foodsaver.model.Usuario;
import com.foodsaver.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String login(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario != null && usuario.getSenha().equals(senha)) {
            return "Login realizado com sucesso!";
        }
        return "Credenciais inválidas";
    }
}