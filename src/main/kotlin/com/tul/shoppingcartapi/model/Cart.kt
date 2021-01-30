package com.tul.shoppingcartapi.model

import javax.persistence.*

@Entity
data class Cart(
    @Id
    @GeneratedValue
    var id: Long ?=null,
    var status: Status = Status.pending
)
