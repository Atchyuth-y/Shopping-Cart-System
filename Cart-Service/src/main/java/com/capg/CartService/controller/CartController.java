package com.capg.CartService.controller;

import com.capg.CartService.exception.CartException;
import com.capg.CartService.model.Cart;
import com.capg.CartService.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService service;

    @PostMapping("/save")
    public Cart addCart(@RequestBody Cart cart){

        return service.addCart(cart);
    }

    @GetMapping("/getAllCarts")
    public ResponseEntity<List<Cart>> getallcarts() throws CartException {
        List<Cart> resultCart = service.getallcarts();
        return new ResponseEntity<List<Cart>>(resultCart, HttpStatus.OK);
    }

    @GetMapping("cartbyId/{cartId}")
    public ResponseEntity<Object> getcartById(@PathVariable("cartId") int cartId) throws CartException
    {
        Cart resultCart;
        try {
            resultCart = service.getcartById(cartId);
            return new ResponseEntity<Object>(resultCart, HttpStatus.OK);
        } catch (CartException e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }


    @PutMapping("update/{cartId}")
    public ResponseEntity<Object> updateCart(@RequestBody Cart cart) throws CartException
    {
        Cart resultCart;
        try {
            resultCart = service.updateCart(cart.getCartId(), cart);
            return new ResponseEntity<Object>(resultCart, HttpStatus.OK);
        } catch (CartException e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }



}
