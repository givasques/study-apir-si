package com.github.acnaweb.study_apir.dto;

import java.math.BigDecimal;

import com.github.acnaweb.study_apir.model.Produto;

public class ProdutoRequestUpdate {
    private BigDecimal valor;

    public Produto toModel (Produto product) {
        product.setValor(this.valor);
        return product;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
