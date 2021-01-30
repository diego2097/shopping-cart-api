package com.tul.shoppingcartapi.exceptions.handler

import org.springframework.http.HttpStatus

class ApiRestError(
    var status: HttpStatus,
    var message:String
){
    companion object {
        const val DESCRIPTION="Unexpected error"
    }
    constructor():this(HttpStatus.FOUND,"")
    constructor(status:HttpStatus):this(status,"")
}