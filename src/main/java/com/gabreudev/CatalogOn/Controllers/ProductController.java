package com.gabreudev.CatalogOn.Controllers;

import com.gabreudev.CatalogOn.Entities.Product;
import com.gabreudev.CatalogOn.Servicies.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping()
    public ResponseEntity<Iterable<Product>> getAll() {
        Iterable<Product> products = service.getAll();
        return ResponseEntity.ok(products);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping()
    public ResponseEntity<String> postProduct(@RequestBody Product data){
        String id = service.create(data);
        return ResponseEntity.ok(id);
        }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProduct(@PathVariable String id){
        Optional<Product> product = service.getProduct(id);
        return ResponseEntity.ok(product);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id){
        String deletedProductId = service.deleteProduct(id);
        return ResponseEntity.ok(deletedProductId);
    }

}


