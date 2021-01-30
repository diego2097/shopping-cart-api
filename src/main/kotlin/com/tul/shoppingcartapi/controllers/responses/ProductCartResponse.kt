package com.tul.shoppingcartapi.controllers.responses

import com.tul.shoppingcartapi.model.Status
import jdk.jshell.Snippet

class ProductCartResponse (
    var cartId: Long ?=null,
    var productId: Long ?=null,
    var quantity: Int=0
)