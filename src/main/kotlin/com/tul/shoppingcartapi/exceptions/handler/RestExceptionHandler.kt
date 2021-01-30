package com.tul.shoppingcartapi.exceptions.handler

import com.tul.shoppingcartapi.exceptions.*
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
class RestExceptionHandler : ResponseEntityExceptionHandler()  {

    @ExceptionHandler(value = [(ProductNotFoundException::class),(CartNotFoundException::class),
        (ProductNotInCarException::class)])
    fun handleEntityNotFound(ex:Exception): ResponseEntity<ApiRestError> {
        var apiError=ApiRestError(HttpStatus.NOT_FOUND,ex.localizedMessage)
        return buildResponseEntity(apiError)
    }

    fun buildResponseEntity(apiRestError:ApiRestError): ResponseEntity<ApiRestError>{
        return ResponseEntity(apiRestError,apiRestError.status)
    }
}