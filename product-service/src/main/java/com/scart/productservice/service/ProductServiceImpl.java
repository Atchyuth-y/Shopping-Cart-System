package com.scart.productservice.service;

import com.scart.productservice.model.Product;
import com.scart.productservice.model.User;
import com.scart.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Product addProducts(Product product) {
        product.setProductId(sequenceGeneratorService.getSequenceNumber(Product.SEQUENCE_NAME));
       // Profile profile = restTemplate.getForObject("http://localhost:5050/profile/show"+product.getProfileId(), Profile.class);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(int productId) {
        Optional<Product> product=productRepository.findById(productId);
        return product;
    }

    @Override
    public Product updateProducts(Product product, int productId) {
        Product pro= productRepository.findById(productId).get();
        pro.setProductType(product.getProductType());
        pro.setProductName(product.getProductName());
        pro.setCategory(product.getCategory());
        pro.setImage(product.getImage());
        pro.setPrice(product.getPrice());
        pro.setDescription(product.getDescription());
        pro.setSpecification(product.getSpecification());
        return productRepository.save(pro);
    }

    @Override
    public void deleteProductsById(int productId) {
        productRepository.deleteById(productId);

    }
}
