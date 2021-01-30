package com.tul.shoppingcartapi.services.impl

import com.tul.shoppingcartapi.model.Product
import com.tul.shoppingcartapi.repositories.ProductRepository
import com.tul.shoppingcartapi.services.ProductServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl @Autowired constructor(
    var productRepository: ProductRepository):ProductServices{

    override fun getAllProducts(): List<Product> {
        return productRepository.findAll().toList()
    }

    override fun createProduct(product: Product): Product {
        return productRepository.save(product)
    }

    override fun deleteAllProducts() {
        productRepository.deleteAll()
    }
}