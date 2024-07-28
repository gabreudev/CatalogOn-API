package com.gabreudev.CatalogOn.Entities;

import com.gabreudev.CatalogOn.Dtos.ProductRequestDTO;
import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Product {

    @PrimaryKey
    private UUID id;

    private String nome;

    private String descricao;

    private Float preco;

    private String img;

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Float getPreco() {
        return preco;
    }

    public String getImg() {
        return img;
    }
    public Product(ProductRequestDTO request){
        this.id = UUID.randomUUID();
        this.nome = request.nome();
        this.descricao = request.descricao();
        this.preco = request.preco();
        this.img = request.img();
    }
}

