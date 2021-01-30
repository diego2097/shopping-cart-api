package com.tul.shoppingcartapi.model

import javax.persistence.*

@Entity
data class ProductCart(
    @EmbeddedId
    var id: ProductCartId ?=null,
    @MapsId("product_id")
    @ManyToOne(fetch = FetchType.EAGER)
    var product: Product?=null,
    @MapsId("cart_id")
    @ManyToOne(fetch = FetchType.LAZY)
    var cart: Cart?=null,
    var quantity: Int=0
)