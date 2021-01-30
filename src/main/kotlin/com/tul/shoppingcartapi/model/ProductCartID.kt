package com.tul.shoppingcartapi.model

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class ProductCartId(
    var product_id: Long = 0,

    var cart_id: Long = 0
): Serializable