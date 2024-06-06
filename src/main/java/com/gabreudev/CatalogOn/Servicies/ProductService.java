package com.gabreudev.CatalogOn.Servicies;

import com.gabreudev.CatalogOn.Dtos.ProductRequestDTO;
import com.gabreudev.CatalogOn.Dtos.ProductResponseDTO;
import com.gabreudev.CatalogOn.Entities.Product;
import com.gabreudev.CatalogOn.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<ProductResponseDTO> getAll(){
        List<ProductResponseDTO> products = repository.findAll().stream().map(ProductResponseDTO::new).toList();
        return products;

    }

    public void create(ProductRequestDTO data) {
        Product entity = new Product(data);
        Product product = repository.save(entity);
    }
}
