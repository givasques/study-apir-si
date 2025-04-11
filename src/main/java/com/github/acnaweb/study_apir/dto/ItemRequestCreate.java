package com.github.acnaweb.study_apir.dto;

import java.math.BigDecimal;
 
public class ItemRequestCreate {    
    private Long produtoId;
    private BigDecimal valor;
    private BigDecimal quantidade;
 
    public Long getProduto_id() {
        return produtoId;
    }
    public void setProduto_id(Long produto_id) {
        this.produtoId = produto_id;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public BigDecimal getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }
 
}
