package Controllers;

import Entities.Product;
import Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping("/listproducts")
    public List<Product> getAll(){
        List<Product> products = repository.findAll();
        return products;
    }

}
