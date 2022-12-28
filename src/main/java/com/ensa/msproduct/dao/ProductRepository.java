package com.ensa.msproduct.dao;

import com.ensa.msproduct.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    public Product findProductByDesignation(String designation);
    public Product findProductById(Long id);
}
