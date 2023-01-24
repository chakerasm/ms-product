package com.ensa.msproduct.services;
import com.ensa.msproduct.entities.Product;


import java.util.List;


public interface ProductService {

    List<Product> getProducts();
    Long getProductsCount();

    Long availableProductsCount();
    Long unavailableProductsCount();
    List<Product> getProductByDesignation(String designation);
    Product getProductById(Long id);
    Product addProduct(Product product);
    Product editProduct(Long id,Product product);
    void deleteProduct(Long id);

}
