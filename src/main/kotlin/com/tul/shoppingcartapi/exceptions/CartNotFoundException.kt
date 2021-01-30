package com.tul.shoppingcartapi.exceptions

class CartNotFoundException(message: String) : Exception(DESCRIPTION + message) {
    companion object {
        const val DESCRIPTION="Cart Not found, ID "
    }
}