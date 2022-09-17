package com.scart.productservice.service;

import com.scart.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ProductService {
    public Product addProducts(Product product);
    public List<Product> getAllProducts();
    public Optional<Product> getProductById(int productId);
    public Product updateProducts(Product product, int productId);
    public void deleteProductsById(int productId);
}
