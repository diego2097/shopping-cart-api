package com.tul.shoppingcartapi.repositories

import com.tul.shoppingcartapi.model.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: CrudRepository<Product, Long> {
}