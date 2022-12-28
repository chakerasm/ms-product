package com.ensa.msproduct.services;

import com.ensa.msproduct.dao.ProductRepository;
import com.ensa.msproduct.entities.Product;
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
        return productRepository.findProductByDesignation(designation);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product editProduct(Long id, Product product) {

        Product updatedProduct = productRepository.findById(id).get();
        updatedProduct.setDesignation(product.getDesignation());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setPhoto(product.getPhoto());
        updatedProduct.setDepositQuantity(product.getDepositQuantity());
        updatedProduct.setExpirationDate(product.getExpirationDate());
        updatedProduct.setShortDescription(product.getShortDescription());

        return productRepository.save(updatedProduct);
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findProductById(id);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
