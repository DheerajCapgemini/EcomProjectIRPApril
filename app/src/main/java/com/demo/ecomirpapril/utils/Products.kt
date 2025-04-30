package com.demo.ecomirpapril.utils


import com.demo.ecomirpapril.R
import com.demo.ecomirpapril.model.Product


object Products {
    val products = listOf(
        Product(
            id = 1,
            title = "Laptop",
            image = R.drawable.laptop,
            price = 73900.0,
            description = "i am using the laptop",
        ),
        Product(
            id = 2,
            title = "Mouse",
            image = R.drawable.laptop,
            price = 8500.0,
            description = "i am using the Mouse",
        ),
        Product(
            id = 3,
            title = "Headphones",
            image = R.drawable.laptop,
            price = 29990.0,
            description = "Tab",
        ),
        Product(
            id = 4,
            title = "Watch",
            image = R.drawable.laptop,
            price = 41900.0,
            description = "Track your fitness,Tablet.",
        ),
        Product(
            id = 5,
            title = "Samsung Galaxy Tab S9",
            image = R.drawable.laptop,
            price = 85000.0,
            description = "A powerful tablet",
        ),
        Product(
            id = 6,
            title = "Logitech MX Master 3S Mouse",
            image = R.drawable.laptop,
            price = 10999.0,
            description = "Designed for precision",
        )
    )
}
