package com.foodsaver.controller;

import com.foodsaver.model.Loja;
import com.foodsaver.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Dica UML: Esta classe representa a interface "Boundary" (Fronteira) no diagrama de robustez/sequência, 
// recebendo as requisições HTTP do Frontend (React).
@RestController
@RequestMapping("/api/lojas")
public class LojaController {

    @Autowired
    private LojaService lojaService;

    // Dica Código: Rota para o UC-01 (Cadastro de Loja)
    @PostMapping("/cadastrar")
    public ResponseEntity<Loja> cadastrar(@RequestBody Loja loja) {
        try {
            Loja novaLoja = lojaService.cadastrarLoja(loja);
            return new ResponseEntity<>(novaLoja, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Dica Código: Rota para o Cliente visualizar lojas (Parte do UC-08)
    @GetMapping
    public ResponseEntity<List<Loja>> listar() {
        return new ResponseEntity<>(lojaService.listarLojas(), HttpStatus.OK);
    }
}