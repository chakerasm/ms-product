package com.ensa.msproduct.exceptions;
import org.springframework.http.ResponseEntity;



public interface ProductExceptionHandler {
    ResponseEntity<Object> productNotFount();
    ResponseEntity<Object> productAlreadyExists();
    ResponseEntity<Object> negativeValues();
    ResponseEntity<Object> noAvailableProducts();
}
