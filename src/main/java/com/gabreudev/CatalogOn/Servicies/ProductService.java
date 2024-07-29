package com.gabreudev.CatalogOn.Servicies;

import com.gabreudev.CatalogOn.Dtos.ProductRequestDTO;
import com.gabreudev.CatalogOn.Dtos.ProductResponseDTO;
import com.gabreudev.CatalogOn.Entities.Product;
import com.gabreudev.CatalogOn.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<ProductResponseDTO> getAll(){
        List<ProductResponseDTO> products = repository.findAll().stream().map(ProductResponseDTO::new).toList();
        return products;

    }

    public UUID create(ProductRequestDTO data) {
        Product entity = new Product(data);
        Product product = repository.save(entity);
        ProductResponseDTO created = new ProductResponseDTO(product);
        return created.id();
    }

    public ProductResponseDTO getProduct(UUID id) {
        Optional<Product> product = repository.findById(id);
        ProductResponseDTO productDTO = new ProductResponseDTO(product.orElse(null));
        return productDTO;
    }

    public UUID deleteProduct(UUID id) {
        Optional<Product> product = repository.findById(id);
        repository.deleteById(id);
        ProductResponseDTO productDTO = new ProductResponseDTO(product.orElse(null));
        return productDTO.id();
    }
}
