package com.foodsaver.repository;

import com.foodsaver.model.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Dica Código/UML: O padrão Repository aqui substitui as antigas classes DAO (Data Access Object) 
// que costumavam aparecer nos diagramas de sequência para acesso a banco.
@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {
    Loja findByCnpj(String cnpj);
}