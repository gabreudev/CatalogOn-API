package com.gabreudev.CatalogOn.Servicies;

import com.gabreudev.CatalogOn.Entities.Product;
import com.gabreudev.CatalogOn.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Iterable<Product> getAll(){
        return repository.findAll();


    }

    public String create(Product data) {
        Product product = repository.save(data);
        return product.getId();
    }

    public Optional<Product> getProduct(String id) {
        Optional<Product> product = repository.findById(id);
        return product;
    }

    public String deleteProduct(String id) {
        Optional<Product> product = repository.findById(id);
        repository.deleteById(id);
        return product.get().getId();
    }
}
