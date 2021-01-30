package com.tul.shoppingcartapi.exceptions

class ProductNotFoundException(message: String) : Exception(DESCRIPTION + message) {
    companion object {
        const val DESCRIPTION="Product Not found, ID "
    }
}