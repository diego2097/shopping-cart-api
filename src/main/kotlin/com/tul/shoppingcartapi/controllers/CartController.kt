package com.tul.shoppingcartapi.controllers

import com.tul.shoppingcartapi.model.Cart
import com.tul.shoppingcartapi.services.CartServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/carts")
class CartController @Autowired constructor(
    var cartServices: CartServices){

    @GetMapping
    fun getCarts(): ResponseEntity<List<Cart>> {
        return ResponseEntity(cartServices.getAllCarts(), HttpStatus.OK)
    }

    @PostMapping("/create")
    fun createCart() : ResponseEntity<Cart> {
        var cart = cartServices.createCart()
        return ResponseEntity(cart, HttpStatus.CREATED)
    }

    @DeleteMapping("/delete")
    fun deleteCarts(){
        cartServices.deleteAllCarts()
    }
}