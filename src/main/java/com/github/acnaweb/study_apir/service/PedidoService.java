package com.github.acnaweb.study_apir.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.acnaweb.study_apir.dto.PedidoRequestCreate;
import com.github.acnaweb.study_apir.model.Item;
import com.github.acnaweb.study_apir.model.Pedido;
import com.github.acnaweb.study_apir.repository.PedidoRepository;

@Service
public class PedidoService {

    // @Autowired
    // PedidoRepository pedidoRepository;

//     // public Pedido createPedido (PedidoRequestCreate dto) {
//     //     Pedido pedido = new Pedido();
//     //     pedido.setStatus(dto.getStatus());
//     //     pedido.setItens (new ArrayList<Item>());
//     //     pedidoRepository.save(pedido);
//     //     return pedido;
//     // }

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

