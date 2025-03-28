package com.github.acnaweb.study_apir.dto;

import java.math.BigDecimal;

import com.github.acnaweb.study_apir.model.Product;

public class ProductResponse {
    private Long id;
    private String nome;
    private BigDecimal valor;

    public ProductResponse toDto (Product product) {
        this.setId(product.getId());
        this.setNome(product.getNome());
        this.setValor(product.getValor());
        return this;
    }

    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }    
}
