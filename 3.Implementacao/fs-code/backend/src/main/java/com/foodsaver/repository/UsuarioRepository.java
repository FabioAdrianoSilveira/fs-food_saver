package com.foodsaver.repository;

import com.foodsaver.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository {

    public Usuario findByEmail(String email) {
        // Mock (substituir por JPA depois)
        if (email.equals("teste@email.com")) {
            return new Usuario(1L, "Teste", email, "123");
        }
        return null;
    }
}