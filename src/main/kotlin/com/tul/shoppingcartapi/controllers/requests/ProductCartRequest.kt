package com.tul.shoppingcartapi.controllers.requests

data class ProductCartRequest (
    var productID: Long,
    var quantity: Int
)
