package com.tul.shoppingcartapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Product(
    @Id
    @GeneratedValue
    var id: Long ?=null,
    var nombre: String="",
    var sku: String="",
    var description: String=""
)