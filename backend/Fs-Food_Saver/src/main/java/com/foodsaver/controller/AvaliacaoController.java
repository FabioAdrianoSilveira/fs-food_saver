package com.foodsaver.controller;

import com.foodsaver.model.Avaliacao;
import com.foodsaver.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    // UC-05: Cliente faz uma avaliação
    @PostMapping("/criar")
    public ResponseEntity<Avaliacao> criarAvaliacao(@RequestBody Avaliacao avaliacao) {
        if(avaliacao.getNota() < 1 || avaliacao.getNota() > 5) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Avaliacao novaAvaliacao = avaliacaoRepository.save(avaliacao);
        return new ResponseEntity<>(novaAvaliacao, HttpStatus.CREATED);
    }

    // Listar avaliações de uma loja
    @GetMapping("/loja/{lojaId}")
    public ResponseEntity<List<Avaliacao>> listarPorLoja(@PathVariable Long lojaId) {
        return new ResponseEntity<>(avaliacaoRepository.findByLojaId(lojaId), HttpStatus.OK);
    }
}