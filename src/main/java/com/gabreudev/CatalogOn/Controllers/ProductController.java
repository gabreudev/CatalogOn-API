package com.gabreudev.CatalogOn.Controllers;

import com.gabreudev.CatalogOn.Dtos.ProductRequestDTO;
import com.gabreudev.CatalogOn.Dtos.ProductResponseDTO;
import com.gabreudev.CatalogOn.Servicies.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping()
    public ResponseEntity<List<ProductResponseDTO>> getAll() {
        List<ProductResponseDTO> products = service.getAll();
        return ResponseEntity.ok(products);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping()
    public ResponseEntity<UUID> postProduct(@RequestBody ProductRequestDTO data){
        UUID id = service.create(data);
        return ResponseEntity.ok(id);
        }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable UUID id){
        ProductResponseDTO product = service.getProduct(id);
        return ResponseEntity.ok(product);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<UUID> deleteProduct(@PathVariable UUID id){
        UUID deletedProductId = service.deleteProduct(id);
        return ResponseEntity.ok(deletedProductId);
    }

}


