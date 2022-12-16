package com.example.demo.controller;

import com.example.demo.enitity.Cart;
import com.example.demo.enitity.User;
import com.example.demo.payload.ApiResponse;
import com.example.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/create")
    public ApiResponse createCart(@RequestBody Cart cartReq){

        Cart cart = new Cart(cartReq.getBook(),cartReq.getQuantity(),cartReq.getUser_id());
        cartRepository.save(cart);
        return new ApiResponse(0);
    }

    @PostMapping("/update")
    public ApiResponse updateCart(@RequestBody Cart cartReq ){
        cartRepository.updateCartQuantity(cartReq.getQuantity(),cartReq.getId());
        return new ApiResponse(0) ;
    }

    @PostMapping ("/delete")
    public ApiResponse deleteCart(@RequestBody Cart cartReq){
        cartRepository.deleteCart(cartReq.getId());
        return new ApiResponse(0);
    }

    @GetMapping("/")
    public ArrayList<Cart> getCart(@RequestBody User userReq){
        return cartRepository.getCartById(userReq.getId());
    }



}

;
