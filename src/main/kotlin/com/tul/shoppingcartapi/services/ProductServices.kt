package com.tul.shoppingcartapi.services

import com.tul.shoppingcartapi.model.Product
import org.springframework.stereotype.Service


interface ProductServices {
    fun getAllProducts():List<Product>
    abstract fun createProduct(product: Product): Product
    fun deleteAllProducts()
}