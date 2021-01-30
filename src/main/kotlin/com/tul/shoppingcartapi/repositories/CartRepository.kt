package com.tul.shoppingcartapi.repositories

import com.tul.shoppingcartapi.model.Cart
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CartRepository : CrudRepository<Cart, Long> {
}