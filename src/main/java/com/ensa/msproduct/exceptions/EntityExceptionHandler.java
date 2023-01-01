package com.ensa.msproduct.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class EntityExceptionHandler {

    @ExceptionHandler(value = {EntityAlreadyExistsException.class})
    public ResponseEntity<EntityException> handleAlreadyExistsException(EntityAlreadyExistsException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        EntityException entityException = new EntityException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(entityException, badRequest);
    }
    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<EntityException> handleNotFoundException(EntityNotFoundException e){
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        EntityException entityException = new EntityException(
                e.getMessage(),
                notFound,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(entityException, notFound);
    }

    @ExceptionHandler(value = {NegativeValuesException.class})
    public ResponseEntity<EntityException> handleNegativeValuesException(NegativeValuesException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        EntityException entityException = new EntityException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(entityException, badRequest);
    }
}
