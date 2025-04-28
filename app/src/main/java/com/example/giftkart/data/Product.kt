package com.example.giftkart.data

data class Product(
    val id: String,
    val name: String,
    val category: String,
    val description: String,
    val price: Double,
    val imageResource: Int,
    val sizeOptions: List<String>? = null,
    val inkColors: List<String>? = null,
    val additionalImages: List<Int>? = null // NEW: For multiple additional images
)