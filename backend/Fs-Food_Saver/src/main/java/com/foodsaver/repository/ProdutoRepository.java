package com.foodsaver.repository;

import com.foodsaver.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Método de busca customizado para atender o UC-07 (Pesquisar alimentos)
    List<Produto> findByNomeContainingIgnoreCase(String nome);
}