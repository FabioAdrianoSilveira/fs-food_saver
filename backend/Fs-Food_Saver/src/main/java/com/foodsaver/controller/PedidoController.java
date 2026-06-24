package com.foodsaver.controller;

import com.foodsaver.model.Pedido;
import com.foodsaver.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Classe Boundary (Fronteira) para o módulo de Pedidos/Encomendas.
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // UC-04: Cliente realiza pedido
    @PostMapping("/criar")
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        Pedido novoPedido = pedidoService.criarPedido(pedido);
        return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
    }

    // UC-09: Cliente visualiza o seu histórico
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Pedido>> listarPedidosCliente(@PathVariable Long clienteId) {
        return new ResponseEntity<>(pedidoService.listarPedidosDoCliente(clienteId), HttpStatus.OK);
    }

    // Lojista visualiza pedidos recebidos
    @GetMapping("/loja/{lojaId}")
    public ResponseEntity<List<Pedido>> listarPedidosLoja(@PathVariable Long lojaId) {
        return new ResponseEntity<>(pedidoService.listarPedidosDaLoja(lojaId), HttpStatus.OK);
    }

    // Lojista atualiza o status (Ex: de PENDENTE para CONFIRMADO)
    @PatchMapping("/{id}/status")
    public ResponseEntity<Pedido> atualizarStatus(@PathVariable Long id, @RequestParam String status) {
        Pedido pedidoAtualizado = pedidoService.atualizarStatus(id, status);
        return new ResponseEntity<>(pedidoAtualizado, HttpStatus.OK);
    }
}