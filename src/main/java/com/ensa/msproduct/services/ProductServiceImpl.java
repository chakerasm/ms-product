package com.ensa.msproduct.services;

import com.ensa.msproduct.dao.ProductRepository;
import com.ensa.msproduct.entities.Product;
import com.ensa.msproduct.exceptions.EntityAlreadyExistsException;
import com.ensa.msproduct.exceptions.EntityNotFoundException;
import com.ensa.msproduct.exceptions.NegativeValuesException;
import com.jayway.jsonpath.Criteria;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;
import java.util.Optional;

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
    public Long getProductsCount() {
        return productRepository.count();
    }

    @Override
    public Long availableProductsCount() {
        return productRepository.availableProducts();
    }

    @Override
    public Long unavailableProductsCount() {
        return productRepository.unavailableProducts();
    }


    @Override
    public List<Product> getProductByDesignation(String designation) {
        List<Product> products = productRepository.findProductByDesignation(designation);
        if(products.isEmpty() ){
            throw new EntityNotFoundException("cannot find any product with the designation" + " " + designation);
        }
        return products;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent() ){
            return product.get() ;
        }
        throw new EntityNotFoundException("The product doesn't exists");
    }

    @Override
    public Product addProduct(Product product) {
        if(productRepository.findProductById(product.getId()) != null ){
            throw new EntityAlreadyExistsException("The product already exists");
        }
        if(product.getPrice()  < 0){
            throw new NegativeValuesException("The product's price cannot be negative");
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
        if(product.getPrice() < 0 ){
            throw new NegativeValuesException("The product's price cannot be negative");
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
