package com.github.acnaweb.study_apir.dto;

import java.math.BigDecimal;

import com.github.acnaweb.study_apir.model.Product;

public class ProductRequestCreate {
    private String nome;

    public Product toModel () {
        BigDecimal VALOR_PADRAO = new BigDecimal (200);
        Product product = new Product();
        product.setNome(this.nome);
        product.setValor(VALOR_PADRAO);
        return product;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
