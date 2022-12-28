package com.ensa.msproduct.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductExceptionHandlerImpl implements ProductExceptionHandler {

    @Override
    public ResponseEntity<Object> productNotFount() {
        return new ResponseEntity<>("The product doesn't exist", HttpStatus.NOT_FOUND) ;
    }

    @Override
    public ResponseEntity<Object> productAlreadyExists() {
        return new ResponseEntity<>("The product already exists", HttpStatus.BAD_REQUEST) ;
    }

    @Override
    public ResponseEntity<Object> negativeValues() {
        return new ResponseEntity<>("The price or the quantity cannot be negative", HttpStatus.BAD_REQUEST) ;
    }

    @Override
    public ResponseEntity<Object> noAvailableProducts() {
        return new ResponseEntity<>("No available products",HttpStatus.OK) ;
    }
}
