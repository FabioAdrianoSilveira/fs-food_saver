package com.foodsaver.repository;

import com.foodsaver.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// O repositório lida com o acesso aos dados. Criamos métodos para o UC-09 (Ver Histórico).
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
    // Para o Cliente ver os seus próprios pedidos
    List<Pedido> findByClienteId(Long clienteId);
    
    // Para o Lojista ver os pedidos da sua loja
    List<Pedido> findByLojaId(Long lojaId);
}