package com.tul.shoppingcartapi.controllers.requests

data class AddProductCartRequest
    constructor
    (var productID: Long,
     var cartID: Long,
     var quantity: Int) {
}