package com.tul.shoppingcartapi.services.impl

import com.tul.shoppingcartapi.controllers.responses.CartResponse
import com.tul.shoppingcartapi.controllers.responses.ProductCartResponse
import com.tul.shoppingcartapi.controllers.responses.ProductResponse
import com.tul.shoppingcartapi.controllers.responses.ProductsInCarResponse
import com.tul.shoppingcartapi.exceptions.CartNotFoundException
import com.tul.shoppingcartapi.exceptions.ProductNotFoundException
import com.tul.shoppingcartapi.exceptions.ProductNotInCarException
import com.tul.shoppingcartapi.model.*
import com.tul.shoppingcartapi.repositories.CartRepository
import com.tul.shoppingcartapi.repositories.ProductCartRepository
import com.tul.shoppingcartapi.repositories.ProductRepository
import com.tul.shoppingcartapi.services.CartServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CartServiceImpl  @Autowired constructor(
    var cartRepository: CartRepository,
    var productRepository: ProductRepository,
    var productCartRepository: ProductCartRepository): CartServices {

    override fun getAllCarts(): List<CartResponse> {
        var responseList = ArrayList<CartResponse>()
        for (cart: Cart in cartRepository.findAll()){
            responseList.add(CartResponse(cart.id,cart.status))
        }
        return responseList
    }

    override fun createCart(): CartResponse {
        var cart = cartRepository.save(Cart())
        return CartResponse(cart.id,cart.status)
    }

    override fun deleteAllCarts() {
        cartRepository.deleteAll()
    }

    override fun addProductToCart(cartId: Long, productId: Long, quantity: Int) : ProductCartResponse {
        validateCarExist(cartId)
        validateProductExist(productId)
        var cart = cartRepository.findById(cartId).get()
        var product = productRepository.findById(productId).get()
        var productCart = productCartRepository.findById(ProductCartId(productId, cartId))
        //verificar si ese producto ya esta en la lista
        if (productCart.isPresent)
            for (pd: ProductCart in cart.products){
                if (pd.equals(productCart.get())){
                    pd.quantity+=quantity
                    cartRepository.save(cart)
                }
            }
        else{
            var productCart = ProductCart(ProductCartId(productId,cartId))
            productCart.cart = cart
            productCart.product = product
            productCart.quantity = quantity
            cart.products.add(productCart)
            cartRepository.save(cart)
            return ProductCartResponse(cartId,productId, productCart.quantity)
        }
        return ProductCartResponse(cartId,productId,productCart.get().quantity)
    }

    override fun deleteProductFromCart(cartId: Long, productId: Long) {
        validateCarExist(cartId)
        validateProductExist(productId)
        var cart = cartRepository.findById(cartId).get()
        var product = productRepository.findById(productId).get()
        var productCart = productCartRepository.findById(ProductCartId(productId, cartId))
        //verificar que el producto esta en la lista
        if (productCart.isPresent){
            cart.products.remove(productCart.get())
            cartRepository.save(cart)
            productCartRepository.deleteById(ProductCartId(productId, cartId))
        }
    }

    override fun updateProductCart(cartId: Long, productId: Long, quantity: Int) : ProductCartResponse{
        validateCarExist(cartId)
        validateProductExist(productId)
        validateProductExistInCar(productId,cartId)
        var cart = cartRepository.findById(cartId).get()
        var product = productRepository.findById(productId).get()
        var productCart = productCartRepository.findById(ProductCartId(productId, cartId))
        for (pd: ProductCart in cart.products){
            if (pd.equals(productCart.get())){
                pd.quantity = quantity
                cartRepository.save(cart)
            }
        }
        return ProductCartResponse(cartId,productId, productCart.get().quantity)
    }
    override fun checkoutCart(cartId: Long): CartResponse {
        validateCarExist(cartId)
        var cart = cartRepository.findById(cartId).get()
        cart.status = Status.completed
        cartRepository.save(cart)
        return CartResponse(cart.id,cart.status)
    }

    override fun getProductsOfCar(cartId: Long): List<ProductsInCarResponse> {
        validateCarExist(cartId)
        var cart = cartRepository.findById(cartId).get()
        var listResponse = ArrayList<ProductsInCarResponse>()
        for (pd: ProductCart in cart.products){
            var product = pd.product
            if (product != null) {
                listResponse.add(ProductsInCarResponse(product.id,product.nombre,pd.quantity))
            }
        }
        return listResponse
    }

    fun validateCarExist(cartId: Long){
        cartRepository.findById(cartId).orElseThrow { CartNotFoundException(cartId.toString()) }
    }

    fun validateProductExist(productId: Long){
        productRepository.findById(productId).orElseThrow { ProductNotFoundException(productId.toString()) }
    }

    fun validateProductExistInCar(productId: Long, cartId: Long){
        var productCart = productCartRepository.findById(ProductCartId(productId, cartId))
        if (!productCart.isPresent){
            throw ProductNotInCarException(productId.toString(), cartId.toString())
        }
    }
}