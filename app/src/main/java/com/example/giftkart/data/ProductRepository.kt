package com.example.giftkart.data

import com.example.giftkart.R

object ProductRepository {

    // List of products
    private val products = listOf(
        // Bags
        Product(
            id = "bag1",
            name = "Classic Backpack",
            category = "Bags",
            description = "A durable and stylish backpack for everyday use.",
            price = 1999.00,
            imageResource = R.drawable.bag11,
            additionalImages = listOf(R.drawable.bag12, R.drawable.bag13)
        ),
        Product(
            id = "bag2",
            name = "Leather Messenger Bag",
            category = "Bags",
            description = "A premium leather messenger bag for professionals.",
            price = 1899.00,
            imageResource = R.drawable.bag21,
            additionalImages = listOf(R.drawable.bag22, R.drawable.bag23)
        ),
        Product(
            id = "bag3",
            name = "Travel Duffel Bag",
            category = "Bags",
            description = "Spacious and lightweight duffel bag for travel.",
            price = 1899.00,
            imageResource = R.drawable.bag31,
            additionalImages = listOf(R.drawable.bag32, R.drawable.bag33)
        ),

        // Bottles
        Product(
            id = "bottle1",
            name = "Stainless Steel Water Bottle",
            category = "Bottles",
            description = "Keeps your drinks hot or cold for hours.",
            price = 49.00,
            imageResource = R.drawable.bottle1
        ),
        Product(
            id = "bottle2",
            name = "Durable Water Bottle",
            category = "Bottles",
            description = "Durable glass bottle with a protective sleeve.",
            price = 49.00,
            imageResource = R.drawable.bottle2
        ),
        Product(
            id = "bottle3",
            name = "Thermal Steel Bottle",
            category = "Bottles",
            description = "Perfect for on-the-go hydration and space-saving.",
            price = 49.00,
            imageResource = R.drawable.bottle3
        ),

        // Hoodies
        Product(
            id = "hoodie1",
            name = "Classic Hoodie",
            category = "Hoodies",
            description = "Comfortable and warm hoodie for casual wear.",
            price = 500.00,
            imageResource = R.drawable.hoodie11,
            sizeOptions = listOf("XS", "S", "M", "L", "XL"),
            additionalImages = listOf(R.drawable.hoodie12)
        ),
        Product(
            id = "hoodie2",
            name = "Best Hoodie",
            category = "Hoodies",
            description = "Versatile hoodie with a convenient front zipper.",
            price = 550.00,
            imageResource = R.drawable.hoodie21,
            sizeOptions = listOf("XS", "S", "M", "L", "XL"),
            additionalImages = listOf(R.drawable.hoodie22)
        ),

        // Pens
        Product(
            id = "pen1",
            name = "Ballpoint Pen",
            category = "Pens",
            description = "Smooth writing ballpoint pen with a comfortable grip.",
            price = 150.00,
            imageResource = R.drawable.pen11,
            inkColors = listOf("Black", "Blue", "Red"),
            additionalImages = listOf(R.drawable.pen12)
        ),
        Product(
            id = "pen2",
            name = "Gel Pen",
            category = "Pens",
            description = "Gel ink pen for a smoother and more vivid writing experience.",
            price = 150.00,
            imageResource = R.drawable.pen21,
            inkColors = listOf("Black", "Blue", "Red", "Green"),
            additionalImages = listOf(R.drawable.pen22)
        ),
        Product(
            id = "pen3",
            name = "Roller Ball Pen",
            category = "Pens",
            description = "Classic fountain pen with a premium design.",
            price = 150.00,
            imageResource = R.drawable.pen31,
            inkColors = listOf("Black", "Blue"),
            additionalImages = listOf(R.drawable.pen32)
        ),

        // T-Shirts
        Product(
            id = "tshirt1",
            name = "Classic T-Shirt",
            category = "T-Shirts",
            description = "Soft and comfortable T-shirt for daily wear.",
            price = 600.00,
            imageResource = R.drawable.tshirt11,
            sizeOptions = listOf("XS", "S", "M", "L", "XL"),
            additionalImages = listOf(R.drawable.tshirt12, R.drawable.tshirt13)
        )
    )

    // Function to get products by category
    fun getProductsByCategory(category: String): List<Product> {
        return products.filter { it.category == category }
    }

    // Function to get a product by its ID
    fun getProductById(productId: String): Product? {
        return products.find { it.id == productId }
    }
}