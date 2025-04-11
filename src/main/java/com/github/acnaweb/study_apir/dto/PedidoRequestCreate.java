package com.github.acnaweb.study_apir.dto;

import java.util.List;
 
public class PedidoRequestCreate {    
   
    private List<ItemRequestCreate> items;
   
    public List<ItemRequestCreate> getItems() {
        return items;
    }
 
    public void setItems(List<ItemRequestCreate> items) {
        this.items = items;
    }
 
}
