# Shopping-cart-api
## Objetivo
API construida en spring boot, permite la creacion de un carro de compras entre otras funciones tales como: 
- Lista de productos
- Agregar, eliminar y modificar productos al carrito
- Checkout, solo va a modificar el status a completed
## Descripcion del API
####  URL BASE: /api/v1/ 
#### Construida en: 
- Kotlin
- Spring boot 2.3.4 
- Gradle, Manejador de dependencias.
#### Productos
Cuenta con los siguientes endpoints
- GET /api/v1/products: Permite listar la lista de productos en la tienda.
- POST /api/v1/products/create: Permite crear un producto.
Este metodo recibe un json con el formato 
```json
{
    "nombre": "producto de prueba 3",
    "sku": "sku",
    "description": "description"   
}
```
- DELETE /api/v1/products: Permite borrar todos los productos de la tienda. 
#### Carrito
Cuenta con los siguientes endpoints
- GET /api/v1/carts: Permite listar la lista de productos en la tienda.
- POST /api/v1/carts/create: Permite crear un producto.
- DELETE /api/v1/carts: Permite borrar todos los productos de la tienda. 
- POST /api/v1/{IdCart}/add/product: Permite agregar un producto al carrito
Este metodo recibe un json con el formato
```json
{
    "productID": 1,
    "quantity":4
}
```
- DELETE /api/v1/{idCart}/products/{idProduct}: Permite eliminar un producto del carrito
- POST /api/v1/{idCart}/update/product: Permite actualizar la cantidad de un producto en el carrito
Este metodo recibe un json con el formato
```json
{
    "productID": 1,
    "quantity":8
}
```
- POST /api/v1/{idCart}/checkout: Permite cambiar el estado del carrito a completado
- GET /api/v1/{idCart}/products: Permite listar la lista de productos de un carrito
