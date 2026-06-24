package com.foodsaver.model;

import jakarta.persistence.*;
import java.util.List;

// Esta classe representa a entidade "Loja" no Diagrama de Classes.
// Os atributos mapeiam diretamente para os atributos da classe na UML.
@Entity
@Table(name = "lojas")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cnpj;

    // Relacionamento 1 para Muitos (1..*). 
    // Uma loja possui vários produtos. No diagrama de classes, verifique a multiplicidade entre Loja e Produto.
    @OneToMany(mappedBy = "loja", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Produto> produtos;

    // Construtores, Getters e Setters
    public Loja() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public List<Produto> getProdutos() { return produtos; }
    public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }
}