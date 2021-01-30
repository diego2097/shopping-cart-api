package com.tul.shoppingcartapi.services.impl

import com.tul.shoppingcartapi.controllers.responses.CartResponse
import com.tul.shoppingcartapi.controllers.responses.ProductResponse
import com.tul.shoppingcartapi.model.Cart
import com.tul.shoppingcartapi.model.Product
import com.tul.shoppingcartapi.repositories.ProductRepository
import com.tul.shoppingcartapi.services.ProductServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl @Autowired constructor(
    var productRepository: ProductRepository):ProductServices{

    override fun getAllProducts(): List<ProductResponse> {
        var responseList = ArrayList<ProductResponse>()
        for (product: Product in productRepository.findAll()){
            responseList.add(ProductResponse(product.id,product.nombre))
        }
        return responseList
    }

    override fun createProduct(product: Product): ProductResponse {
        var product = productRepository.save(product)
        return ProductResponse(product.id,product.nombre)
    }

    override fun deleteAllProducts() {
        productRepository.deleteAll()
    }
}