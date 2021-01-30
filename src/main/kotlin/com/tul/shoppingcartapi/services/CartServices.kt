package com.tul.shoppingcartapi.services

import com.tul.shoppingcartapi.model.Cart

interface CartServices {
    fun getAllCarts():List<Cart>
    abstract fun createCart(): Cart
    fun deleteAllCarts()
}