package com.tul.shoppingcartapi.services

import com.tul.shoppingcartapi.controllers.responses.ProductResponse
import com.tul.shoppingcartapi.model.Product
import org.springframework.stereotype.Service


interface ProductServices {
    fun getAllProducts():List<ProductResponse>
    abstract fun createProduct(product: Product): ProductResponse
    fun deleteAllProducts()
}