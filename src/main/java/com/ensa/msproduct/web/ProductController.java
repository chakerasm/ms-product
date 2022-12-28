package com.ensa.msproduct.web;

import com.ensa.msproduct.entities.Product;

import java.util.List;

public interface ProductController {
    List<Product> getProducts();
    Product addProduct(Product product);
    Product editProduct(Long id,Product product);
    void deleteProduct(Long id);

}
