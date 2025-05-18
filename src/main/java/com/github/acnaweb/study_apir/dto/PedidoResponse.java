package com.github.acnaweb.study_apir.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.github.acnaweb.study_apir.model.Pedido;

public class PedidoResponse {
    private Long id;
    private String status;
    private LocalDate dataEntrega;
    private List <ItemResponse> itens;

    public PedidoResponse toDto (Pedido pedido) {
        id = pedido.getId();
        status = pedido.getStatus().getMensagem();
        dataEntrega = pedido.getDataEntrega();
        itens = pedido.getItems()
        .stream()
        .map(i -> new ItemResponse().toDto(i))
        .collect(Collectors.toList());

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
    public List<ItemResponse> getItens() {
        return itens;
    }
    public void setItens(List<ItemResponse> itens) {
        this.itens = itens;
    }
    public LocalDate getDataEntrega() {
        return dataEntrega;
    }
    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}
