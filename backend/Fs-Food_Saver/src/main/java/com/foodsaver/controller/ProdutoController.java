package com.foodsaver.controller;

import com.foodsaver.model.Produto;
import com.foodsaver.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // Rota para UC-03 (Lojista cadastra produto)
    @PostMapping("/cadastrar")
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
        Produto novoProduto = produtoService.cadastrarProduto(produto);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }

    // Rota para UC-07 (Cliente pesquisa alimento específico)
    @GetMapping("/pesquisar")
    public ResponseEntity<List<Produto>> pesquisar(@RequestParam String nome) {
        List<Produto> produtos = produtoService.buscarProdutosPorNome(nome);
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }
}