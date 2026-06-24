package com.foodsaver.service;

import com.foodsaver.model.Loja;
import com.foodsaver.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// No diagrama de sequência do UC-01, esta é a classe "Controller/Controladora" de negócio 
// que orquestra a lógica antes de chamar o banco de dados.
@Service
public class LojaService {

    @Autowired
    private LojaRepository lojaRepository;

    public Loja cadastrarLoja(Loja loja) {
        if (lojaRepository.findByCnpj(loja.getCnpj()) != null) {
            throw new RuntimeException("Loja com este CNPJ já cadastrada.");
        }
        return lojaRepository.save(loja);
    }

    public List<Loja> listarLojas() {
        return lojaRepository.findAll();
    }
}