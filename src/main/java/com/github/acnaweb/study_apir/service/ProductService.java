package com.github.acnaweb.study_apir.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.acnaweb.study_apir.model.Product;

@Service //spring automaticamente instancia essa classe em memória
public class ProductService {
    
    private List<Product> products = new ArrayList<>();

    // para controlar o id dos produtos cadastrados
    private long sequence = 1L;

    public Product createProduct(Product product) {
        product.setId(sequence++);
        products.add(product);
        return product;
    }

    public Product getProductById(Long id) {
        return null;
    }

    public Optional<Product> updateProduct(Long id, Product product) {
        return products.stream()
                .filter(e -> e.getId().equals(id))
                        .findFirst()
                        .map(p -> {
                            p.setNome(product.getNome()); 
                            return p;
                        });
    }

    public void deleteProduct(Long id) {

    }
}
