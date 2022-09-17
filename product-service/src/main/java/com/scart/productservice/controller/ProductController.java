package com.scart.productservice.controller;

import com.scart.productservice.model.Product;
import com.scart.productservice.model.User;
import com.scart.productservice.service.ProductService;
import com.scart.productservice.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public String addProducts(@RequestBody Product product) {
        productService.addProducts(product);
        return "Adding product with id:"+product.getProductId();

    }

   /* @RequestMapping("/uId")
    public List<User> getUser(@PathVariable("uId") int profileId){

        User user = restTemplate.getForObject("http://localhost:5050/profile/show", Profile.class);
        return (List<User>) new User();
    }*/


    @GetMapping("/view")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/update/{id}")
    public Product updateProducts(@RequestBody Product product, @PathVariable("id") int productId) {
        return productService.updateProducts(product, productId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductsById(@PathVariable("id") int productId) {
        productService.deleteProductsById(productId);
    }

    private class getForObject extends User {
        public getForObject(String s, Class<Profile> profileClass) {
        }
    }
}
