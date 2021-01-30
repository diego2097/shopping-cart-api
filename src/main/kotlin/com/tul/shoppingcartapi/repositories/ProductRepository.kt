package com.tul.shoppingcartapi.repositories

import com.tul.shoppingcartapi.model.Product
import org.springframework.data.repository.CrudRepository

interface ProductRepository: CrudRepository<Product, Long> {
}