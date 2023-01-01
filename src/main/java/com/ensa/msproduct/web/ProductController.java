package com.ensa.msproduct.web;

import com.ensa.msproduct.entities.Product;
import com.ensa.msproduct.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }



    @GetMapping("")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(products) ;
    }


    @GetMapping("/search/{designation}")
    public ResponseEntity<Product> getProductByDesignation(@PathVariable String designation) {
        Product product = productService.getProductByDesignation(designation);
        return ResponseEntity.ok(product) ;
    }


    @PostMapping("")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(product)) ;
    }


    @PutMapping("/{id}")
    public ResponseEntity<Product> editProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.editProduct(id,product) ;
        return ResponseEntity.ok(updatedProduct) ;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}

