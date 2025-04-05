package com.github.acnaweb.study_apir.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.acnaweb.study_apir.dto.PedidoRequestCreate;
import com.github.acnaweb.study_apir.dto.PedidoRequestUpdate;
import com.github.acnaweb.study_apir.dto.PedidoResponse;
import com.github.acnaweb.study_apir.model.Pedido;
import com.github.acnaweb.study_apir.service.PedidoService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping ("pedido")
public class ControllerPedido {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity <PedidoResponse> create (@RequestBody PedidoRequestCreate dto) { 
        Pedido pedido = pedidoService.createPedido(dto);
        return ResponseEntity.status(201).body(new PedidoResponse().toDto(pedido));
    }

    @DeleteMapping ("/{id}") 
    public ResponseEntity <PedidoResponse> delete (@PathVariable Long id) { 
        boolean result = pedidoService.deletePedido(id);
        if (result) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping ("/{id}") 
    public ResponseEntity <PedidoResponse> update (@PathVariable Long id, @RequestBody PedidoRequestUpdate dto) { 
        return pedidoService.updatePedido(id, dto)
        .map(p -> {
            return ResponseEntity.ok(new PedidoResponse().toDto(p));
        })
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping ("/{id}") 
    public ResponseEntity <PedidoResponse> getById (@PathVariable Long id) { 
        return pedidoService.getPedidoById(id) 
        .map(p -> {
            return ResponseEntity.ok(new PedidoResponse().toDto(p));
        })
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity <List <PedidoResponse>> getAll () { 
        List <PedidoResponse> response = pedidoService.getAll()
        .stream()
        .map(p -> {
            return new PedidoResponse().toDto(p);
        })
        .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}
