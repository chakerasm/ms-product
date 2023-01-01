package com.ensa.msproduct.services;

import com.ensa.msproduct.dao.ProductRepository;
import com.ensa.msproduct.entities.Product;
import com.ensa.msproduct.exceptions.EntityAlreadyExistsException;
import com.ensa.msproduct.exceptions.EntityNotFoundException;
import com.ensa.msproduct.exceptions.NegativeValuesException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByDesignation(String designation) {
        if(productRepository.findProductByDesignation(designation) == null ){
            throw new EntityNotFoundException("The product doesn't exists !");
        }
        return productRepository.findProductByDesignation(designation);
    }

    @Override
    public Product addProduct(Product product) {
        if(productRepository.findProductById(product.getId()) != null ){
            throw new EntityAlreadyExistsException("The product already exists");
        }
        if(product.getPrice() < 0 || product.getDepositQuantity() < 0){
            throw new NegativeValuesException("The product's price or quantity cannot be negative");
        }
        return productRepository.save(product);
    }

    @Override
    public Product editProduct(Long id, Product product) {

        if(productRepository.findProductById(id) == null ){
            throw new EntityNotFoundException("The product doesn't exists");
        }
        Product updatedProduct = productRepository.findById(id).get();
        updatedProduct.setDesignation(product.getDesignation());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setPhoto(product.getPhoto());
        updatedProduct.setDepositQuantity(product.getDepositQuantity());
        updatedProduct.setExpirationDate(product.getExpirationDate());
        updatedProduct.setShortDescription(product.getShortDescription());
        if(product.getPrice() < 0 || product.getDepositQuantity() < 0){
            throw new NegativeValuesException("The product's price or quantity cannot be negative");
        }

        return productRepository.save(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        if(productRepository.findProductById(id) == null ){
            throw new EntityNotFoundException("The product doesn't exists");
        }
        productRepository.deleteById(id);
    }
}
