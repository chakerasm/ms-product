package com.ensa.msproduct.dao;

import com.ensa.msproduct.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product,Long> {

    @Query(value = "{'designation': {$regex: ?0, $options: 'i'}}")
    public List<Product> findProductByDesignation(String designation);
    public Product findProductById(Long id);
    @Query(value = "{depositQuantity:{$gt:0}}" , count = true)
    public Long availableProducts();
    @Query(value = "{depositQuantity:{$lt:0}}" , count = true)
    public Long unavailableProducts();


}
