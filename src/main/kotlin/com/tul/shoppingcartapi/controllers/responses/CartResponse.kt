package com.tul.shoppingcartapi.controllers.responses

import com.tul.shoppingcartapi.model.Status

data class CartResponse(
    var idCar: Long ? =null,
    var status: Status = Status.pending
)

