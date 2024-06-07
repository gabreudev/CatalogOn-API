package com.gabreudev.CatalogOn.Entities;

import com.gabreudev.CatalogOn.Dtos.ProductRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private Float preco;
    @Column(length = 10000)
    private String img;

    public Long getId() {
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
        this.nome = request.nome();
        this.descricao = request.descricao();
        this.preco = request.preco();
        this.img = request.img();
    }
}

