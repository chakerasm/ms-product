package com.ensa.msproduct.web;

import com.ensa.msproduct.entities.Product;
import com.ensa.msproduct.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")

public class ProductControllerImpl implements ProductController{
    private final ProductService productService;


    public ProductControllerImpl(ProductService productService) {
        this.productService = productService;
    }


    @Override
    @GetMapping("")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @Override
    @PostMapping("")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @Override
    @PutMapping("/{id}")
    public Product editProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.editProduct(id,product);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
