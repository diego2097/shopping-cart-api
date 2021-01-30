package com.tul.shoppingcartapi.services

import com.tul.shoppingcartapi.controllers.responses.CartResponse
import com.tul.shoppingcartapi.controllers.responses.ProductCartResponse
import com.tul.shoppingcartapi.controllers.responses.ProductResponse
import com.tul.shoppingcartapi.controllers.responses.ProductsInCarResponse
import com.tul.shoppingcartapi.model.Cart

interface CartServices {
    fun getAllCarts():List<CartResponse>
    abstract fun createCart(): CartResponse
    fun deleteAllCarts()
    fun addProductToCart(cartId:Long, productId:Long, quantity: Int): ProductCartResponse
    fun deleteProductFromCart(cartId: Long, productId: Long)
    fun updateProductCart(cartId: Long, productId: Long, quantity: Int): ProductCartResponse
    fun checkoutCart(cartId: Long): CartResponse
    fun getProductsOfCar(cartId: Long): List<ProductsInCarResponse>
}