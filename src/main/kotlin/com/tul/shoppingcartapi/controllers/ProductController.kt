package com.tul.shoppingcartapi.controllers

import com.tul.shoppingcartapi.controllers.responses.ProductResponse
import com.tul.shoppingcartapi.model.Product
import com.tul.shoppingcartapi.services.ProductServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/products")
class ProductController @Autowired constructor(
    var productServices: ProductServices) {

    @GetMapping
    fun getProducts():  ResponseEntity<List<ProductResponse>>  {
        return ResponseEntity(productServices.getAllProducts(), HttpStatus.OK)
    }

    @PostMapping("/create")
    fun createProductCart(@RequestBody product: Product):ResponseEntity<ProductResponse> {
        var prod = productServices.createProduct(product)
        return ResponseEntity(prod, HttpStatus.CREATED)
    }

    @DeleteMapping
    fun deleteProducts(): HttpStatus{
        productServices.deleteAllProducts()
        return HttpStatus.OK
    }
}