package com.github.acnaweb.study_apir.dto;

import java.math.BigDecimal;

import com.github.acnaweb.study_apir.model.Item;

public class ItemResponse {
    private Long id;
    private String produtoNome;
    private BigDecimal valor;
    private BigDecimal quantidade;

    public ItemResponse toDto (Item item) {
        id = item.getId();
        produtoNome = item.getProduto().getNome();
        valor = item.getValor();
        quantidade = item.getQuantidade();
        return this;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getProdutoNome() {
        return produtoNome;
    }
    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
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
