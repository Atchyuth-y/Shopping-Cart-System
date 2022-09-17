package com.capg.CartService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product {

    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    private int productId;
    private String productType;
    private String productName;
    private String category;
    private Map<Integer, Double> rating;
    private Map<Integer, String> review;
    private List<String> image;
    private double price;
    private String description;
    private Map<String, String> specification;

}
