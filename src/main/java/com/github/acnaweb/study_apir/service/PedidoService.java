package com.github.acnaweb.study_apir.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.acnaweb.study_apir.dto.PedidoRequestCreate;
import com.github.acnaweb.study_apir.model.Pedido;
import com.github.acnaweb.study_apir.model.Produto;
import com.github.acnaweb.study_apir.repository.PedidoRepository;
import com.github.acnaweb.study_apir.repository.ProdutoRepository;
import com.github.acnaweb.study_apir.repository.ItemRepository;
import com.github.acnaweb.study_apir.model.Item;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ProdutoRepository produtoRepository;


    public Pedido create (PedidoRequestCreate dto) {
        Pedido pedido = new Pedido();
        pedido.setStatus("ABERTO");

        List <Item> itens = dto.getItems()
        .stream()
        .map(i -> {
            Item item = new Item();
            //mapeamento
            Produto produto = produtoRepository
            .findById(i.getProduto_id())
            .orElseThrow(() -> {
                throw new RuntimeException("Produto inexistente: " + i.getProduto_id());
            });

            item.setProduto(produto);
            item.setQuantidade(i.getQuantidade());
            item.setValor(i.getValor());
            item.setPedido(pedido);

            return item;
        })
        .collect(Collectors.toList());

        pedido.setItems(itens);

        return pedidoRepository.save(pedido);
    }

//     // public Optional <Pedido> getPedidoById (Long id) {
//     //     return pedidoRepository.findById(id);
//     // }

//     // public List <Pedido> getAll () {
//     //     return pedidoRepository.findAll();
//     // }

//     // public Optional <Pedido> updatePedido (Long id, PedidoRequestUpdate dto) {
//     //     return pedidoRepository.findById(id)
//     //     .map(p -> {
//     //         p.setId(id);
//     //         p.setStatus(dto.getStatus());
//     //         pedidoRepository.save(p);
//     //         return p;
//     //     });
//     // }

//     // public boolean deletePedido (Long id) {
//     //     Optional<Pedido> opt = pedidoRepository.findById(id);
//     //     if (opt.isPresent()) {
//     //         pedidoRepository.deleteById(id);
//     //         return true;
//     //     }
//     //     return false;
//     // }
}

