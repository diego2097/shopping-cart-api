package com.tul.shoppingcartapi.exceptions

class ProductNotInCarException(message1: String,message2: String )
    : Exception(ProductNotInCarException.DESCRIPTION + "ProductID: " + message1  + " CarID: " + message2)
{
    companion object {
        const val DESCRIPTION="Product not found in car: "
    }
}