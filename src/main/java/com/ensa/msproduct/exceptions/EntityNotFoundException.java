package com.ensa.msproduct.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException (String message ) {
        super(message);
    }

}
