package com.gabreudev.CatalogOn.Controllers;

import com.gabreudev.CatalogOn.Dtos.ProductRequestDTO;
import com.gabreudev.CatalogOn.Dtos.ProductResponseDTO;
import com.gabreudev.CatalogOn.Entities.Product;
import com.gabreudev.CatalogOn.Repositories.ProductRepository;
import com.gabreudev.CatalogOn.Servicies.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity.BodyBuilder postProduct(@RequestBody ProductRequestDTO data){
        service.create(data);
        return ResponseEntity.ok();
        }

}


