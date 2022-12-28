package com.ensa.msproduct.entities;

import jakarta.persistence.Id;

import java.util.Date;

public class Product {

    @Id
    private Long id;
    private String designation;
    private Double price;
    private String photo;
    private Long depositQuantity;
    private Date expirationDate;
    private String shortDescription;
}
