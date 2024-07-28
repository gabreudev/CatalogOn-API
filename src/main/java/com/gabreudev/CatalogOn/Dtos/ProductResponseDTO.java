package com.gabreudev.CatalogOn.Dtos;

import com.gabreudev.CatalogOn.Entities.Product;

import java.util.UUID;

public record ProductResponseDTO(UUID id, String nome, String descricao, Float preco, String img) {

    public ProductResponseDTO(Product product){
        this(product.getId(), product.getNome(), product.getDescricao(), product.getPreco(), product.getImg());
    }
}
