package com.ensa.msproduct.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;

@Document("product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private Long id;
    private String designation;
    private Double price;
    private String photo;
    private Long depositQuantity;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date expirationDate;
    private String shortDescription;
}
