package com.gabreudev.CatalogOn.Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.UUID;

@Document(indexName = "product_index")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Product {

    @Id
    private String id;

    private String nome;

    private String descricao;

    private Float preco;

    private String img;

    public String getId() {
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
    public Product(String nome, String descricao, Float preco, String img){
        this.nome = UUID.randomUUID().toString();
        this.nome = nome;
        this.descricao =descricao;
        this.preco = preco;
        this.img = img;
    }
}

