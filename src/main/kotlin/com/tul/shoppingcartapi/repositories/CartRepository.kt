package com.tul.shoppingcartapi.repositories

import com.tul.shoppingcartapi.model.Cart
import org.springframework.data.repository.CrudRepository

interface CartRepository : CrudRepository<Cart, Long> {
}