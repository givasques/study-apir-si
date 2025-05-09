package com.github.acnaweb.study_apir.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.acnaweb.study_apir.dto.PedidoRequestCreate;
import com.github.acnaweb.study_apir.dto.PedidoResponse;
import com.github.acnaweb.study_apir.service.PedidoService;

@RestController
@RequestMapping("pedidos")
public class ControllerPedido {

    @Autowired
    private PedidoService pedidoService;
 
    @PostMapping
    public ResponseEntity<PedidoResponse> create(@RequestBody PedidoRequestCreate dto) {                      
        return ResponseEntity.status(201).body (new PedidoResponse().toDto(pedidoService.create(dto)));
    }

    @GetMapping ("/{id}")
    public ResponseEntity <PedidoResponse> findById (@PathVariable Long id) {
        return pedidoService.getPedidoById(id)
        .map(pedido -> new PedidoResponse().toDto (pedido))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity <List<PedidoResponse>> findAll () {
        List <PedidoResponse> response = pedidoService.getAll().stream()
        .map(item -> new PedidoResponse().toDto(item))
        .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}
