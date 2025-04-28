package com.example.giftkart.data

data class CartItem(
    val product: Product, // The product added to the cart
    val quantity: Int, // Quantity of the product
    val selectedSize: String? = null, // Selected size (for T-Shirts and Hoodies only)
    val selectedInkColor: String? = null, // Selected ink color (for Pens only)
    val customImageUri: String? = null // URI of the custom image uploaded by the user
)