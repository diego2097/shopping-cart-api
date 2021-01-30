package com.tul.shoppingcartapi.services.impl

import com.tul.shoppingcartapi.model.Cart
import com.tul.shoppingcartapi.repositories.CartRepository
import com.tul.shoppingcartapi.services.CartServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CartServiceImpl  @Autowired constructor(

    var cartRepository: CartRepository): CartServices {

    override fun getAllCarts(): List<Cart> {
        return cartRepository.findAll().toList()
    }

    override fun createCart(): Cart {
        return cartRepository.save(Cart())
    }

    override fun deleteAllCarts() {
        cartRepository.deleteAll()
    }
}