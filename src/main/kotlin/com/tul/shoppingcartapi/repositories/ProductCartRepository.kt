package com.tul.shoppingcartapi.repositories

import com.tul.shoppingcartapi.model.Cart
import com.tul.shoppingcartapi.model.Product
import com.tul.shoppingcartapi.model.ProductCart
import com.tul.shoppingcartapi.model.ProductCartId
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductCartRepository : CrudRepository<ProductCart, ProductCartId> {
}