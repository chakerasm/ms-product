package com.ensa.msproduct.web;

import com.ensa.msproduct.entities.Product;
import com.ensa.msproduct.exceptions.ProductExceptionHandler;
import com.ensa.msproduct.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")

public class ProductControllerImpl implements ProductController{
    private final ProductService productService;
    private final ProductExceptionHandler productExceptionHandler;

    public ProductControllerImpl(ProductService productService, ProductExceptionHandler productExceptionHandler) {
        this.productService = productService;
        this.productExceptionHandler = productExceptionHandler;
    }

    @Override
    @GetMapping("")
    public ResponseEntity<Object>  getProducts() {
        List<Product> products = productService.getProducts();
        if(products.isEmpty()){
            return productExceptionHandler.noAvailableProducts();
        }
        return new ResponseEntity<>(products,HttpStatus.OK) ;
    }

    @Override
    @PostMapping("")
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        if(product.getPrice() < 0 || product.getDepositQuantity() < 0){
            return productExceptionHandler.negativeValues();
        }
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct.getDesignation() + " " + "is created successfully", HttpStatus.CREATED) ;
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Object> editProduct(@PathVariable Long id, @RequestBody Product product) {
        if( productService.findProductById(id) == null ) {
            return productExceptionHandler.productNotFount();
        }
        if(product.getPrice() < 0 || product.getDepositQuantity() < 0){
            return productExceptionHandler.negativeValues();
        }
        Product updatedProduct = productService.editProduct(id,product) ;
        return new ResponseEntity<>( updatedProduct.getDesignation() + " " + "is updated successfully",HttpStatus.OK) ;
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
        if( productService.findProductById(id) == null ) {
            return productExceptionHandler.productNotFount();
        }
        productService.deleteProduct(id);
        return new ResponseEntity<>("The product is deleted successfully",HttpStatus.OK);
    }
}
