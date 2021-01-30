package com.tul.shoppingcartapi.controllers

import com.tul.shoppingcartapi.controllers.requests.ProductCartRequest
import com.tul.shoppingcartapi.controllers.responses.CartResponse
import com.tul.shoppingcartapi.controllers.responses.ProductCartResponse
import com.tul.shoppingcartapi.controllers.responses.ProductResponse
import com.tul.shoppingcartapi.controllers.responses.ProductsInCarResponse
import com.tul.shoppingcartapi.model.Cart
import com.tul.shoppingcartapi.services.CartServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.w3c.dom.html.HTMLTableCaptionElement

@RestController
@RequestMapping("/api/v1/carts")
class CartController @Autowired constructor(
    var cartServices: CartServices){

    @GetMapping
    fun getCarts(): ResponseEntity<List<CartResponse>> {
        return ResponseEntity(cartServices.getAllCarts(), HttpStatus.OK)
    }

    @PostMapping("/create")
    fun createCart() : ResponseEntity<CartResponse> {
        var cart = cartServices.createCart()
        return ResponseEntity(cart, HttpStatus.CREATED)
    }

    @DeleteMapping
    fun deleteAllCarts(){
        cartServices.deleteAllCarts()
    }

    @PostMapping("{idCart}/add/product")
    fun addProductToCart(@PathVariable idCart: Long, @RequestBody productCartRequest: ProductCartRequest): ResponseEntity<ProductCartResponse>{
        var response = cartServices.addProductToCart(idCart, productCartRequest.productID, productCartRequest.quantity)
        return ResponseEntity(response,HttpStatus.OK)
    }

    @DeleteMapping("{idCart}/products/{idProduct}")
    fun deleteProductFromCart(@PathVariable idCart: Long, @PathVariable idProduct: Long ): HttpStatus{
        cartServices.deleteProductFromCart(idCart,idProduct)
        return HttpStatus.OK
    }

    @PostMapping("{idCart}/update/product")
    fun updateProductCart(@PathVariable idCart: Long, @RequestBody productCartRequest: ProductCartRequest): ResponseEntity<ProductCartResponse>{
        var response = cartServices.updateProductCart(idCart,productCartRequest.productID,productCartRequest.quantity)
        return ResponseEntity(response,HttpStatus.OK)
    }

    @PostMapping("{idCart}/checkout")
    fun checkoutCart(@PathVariable idCart: Long): ResponseEntity<CartResponse>{
        var cartResponse = cartServices.checkoutCart(idCart)
        return ResponseEntity(cartResponse, HttpStatus.OK)
    }

    @GetMapping("{idCart}/products")
    fun getProductsOfCar(@PathVariable idCart: Long): ResponseEntity<List<ProductsInCarResponse>>{
        var response = cartServices.getProductsOfCar(idCart)
        return ResponseEntity(response, HttpStatus.OK)
    }
}