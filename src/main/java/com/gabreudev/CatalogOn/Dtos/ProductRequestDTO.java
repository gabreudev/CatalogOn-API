package com.gabreudev.CatalogOn.Dtos;

import com.gabreudev.CatalogOn.Entities.Product;

public record ProductRequestDTO(String nome, String descricao, Float preco, String img) {

    public ProductRequestDTO(Product product){
        this(product.getNome(), product.getDescricao(), product.getPreco(), product.getImg());
    }
}
