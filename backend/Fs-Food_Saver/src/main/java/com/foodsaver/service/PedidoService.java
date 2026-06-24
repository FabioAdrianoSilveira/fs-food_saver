package com.foodsaver.service;

import com.foodsaver.model.Pedido;
import com.foodsaver.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Esta Controladora de Negócio orquestra o fluxo principal (Main Flow) de criar um pedido.
@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido criarPedido(Pedido pedido) {
        // Vincula o pedido a cada item para manter a integridade da relação bidirecional
        if (pedido.getItens() != null) {
            pedido.getItens().forEach(item -> item.setPedido(pedido));
        }
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidosDoCliente(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }

    public List<Pedido> listarPedidosDaLoja(Long lojaId) {
        return pedidoRepository.findByLojaId(lojaId);
    }

    // Atende o fluxo alternativo onde o lojista confirma ou cancela a encomenda
    public Pedido atualizarStatus(Long pedidoId, String novoStatus) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.setStatus(novoStatus);
        return pedidoRepository.save(pedido);
    }
}

