package com.tul.shoppingcartapi.model

import javax.persistence.*

@Entity
data class Cart(
    @Id
    @GeneratedValue
    var id: Long ?=null,
    var status: Status = Status.pending,
    @OneToMany(mappedBy = "cart" ,cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var products : MutableList<ProductCart> = ArrayList()
)
