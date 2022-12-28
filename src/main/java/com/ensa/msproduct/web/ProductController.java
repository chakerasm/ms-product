package com.ensa.msproduct.web;

import com.ensa.msproduct.entities.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductController {
    ResponseEntity<Object> getProducts();

    ResponseEntity<Object> getProductByDesignation(String designation);
    ResponseEntity<Object> addProduct(Product product);
    ResponseEntity<Object> editProduct(Long id,Product product);
    ResponseEntity<Object> deleteProduct(Long id);

}
