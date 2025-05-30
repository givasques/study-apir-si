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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.acnaweb.study_apir.dto.ProdutoRequestCreate;
import com.github.acnaweb.study_apir.dto.ProdutoRequestUpdate;
import com.github.acnaweb.study_apir.dto.ProdutoResponse;
import com.github.acnaweb.study_apir.service.ProdutoService;

@RestController
@RequestMapping("produtos")
public class ControllerProduto {

    @Autowired //avisa o spring quais atributos precisa de ingestao automatica
    private ProdutoService productService;

    @PostMapping
    public ResponseEntity<ProdutoResponse> create(@RequestBody ProdutoRequestCreate dto) {
        return ResponseEntity.status(201).body(
            new ProdutoResponse().toDto(
                productService.createProduct(dto)
            )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean result = productService.deleteProduct(id);

        if (result) {
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> update(@PathVariable Long id, @RequestBody ProdutoRequestUpdate dto) {
        return productService.updateProduct(id, dto)
            .map(productUpdated -> new ProdutoResponse().toDto(productUpdated))
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> findById(@PathVariable Long id) {
        return productService.getProductById(id)
        .map(product -> new ProdutoResponse().toDto(product))
        .map(ResponseEntity::ok)
        .orElse (ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List <ProdutoResponse>> findAll() {
        List<ProdutoResponse> response =
            productService.getAll().stream()
            .map(p -> new ProdutoResponse().toDto(p))
            .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}