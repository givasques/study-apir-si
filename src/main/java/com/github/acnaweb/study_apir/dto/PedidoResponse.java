package com.github.acnaweb.study_apir.dto;

import java.util.List;

import com.github.acnaweb.study_apir.model.Item;
import com.github.acnaweb.study_apir.model.Pedido;

public class PedidoResponse {
    private Long id;
    private String status;
    private List <Item> itens;

    public PedidoResponse toDto (Pedido pedido) {
        this.id = pedido.getId();
        this.status = pedido.getStatus();
        return this;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
