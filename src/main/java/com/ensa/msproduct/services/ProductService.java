package com.ensa.msproduct.services;

import com.ensa.msproduct.dao.ProductRepository;
import com.ensa.msproduct.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    List<Product> getProducts();

    Product getProductByDesignation(String designation);
    Product addProduct(Product product);
    Product editProduct(Long id,Product product);
    void deleteProduct(Long id);

}
