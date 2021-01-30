package com.tul.shoppingcartapi.controllers.responses

data class ProductsInCarResponse(
    var id: Long ?=null,
    var nombre: String="",
    var quantity: Int=0
)
