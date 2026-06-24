package com.foodsaver.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;

// Entidade "Produto". Note que este atende ao UC-03 (Cadastrar produtos para venda).
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private LocalDate dataValidade;

    // Associação Muitos para 1 (*..1). 
    // Reflete a seta de navegabilidade do Produto apontando para a Loja à qual ele pertence.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loja_id", nullable = false)
    @JsonIgnore
    private Loja loja;

    // Construtores, Getters e Setters
    public Produto() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }
    
    public LocalDate getDataValidade() { return dataValidade; }
    public void setDataValidade(LocalDate dataValidade) { this.dataValidade = dataValidade; }

    public Loja getLoja() { return loja; }
    public void setLoja(Loja loja) { this.loja = loja; }
}