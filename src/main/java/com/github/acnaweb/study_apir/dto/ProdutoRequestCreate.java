package com.github.acnaweb.study_apir.dto;

import java.math.BigDecimal;

import com.github.acnaweb.study_apir.model.Produto;

public class ProdutoRequestCreate {
    private String nome;

    public Produto toModel () {
        BigDecimal VALOR_PADRAO = new BigDecimal (200);
        Produto product = new Produto();
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
