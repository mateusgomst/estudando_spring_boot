package com.example.meu_primeiro_springboot.model;

import jakarta.persistence.*;

@Entity //indica que essa classe é uma entidade jpa
@Table(name = "produtos") //indica e define que a tabela sera chamada de produtos
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id sera uma chave primaria gerada automaticamente
    private long id;

    private String nome;
    private Double preco;

    public Produto(){}

    public Produto(String name, Double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
