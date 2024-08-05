package com.jeezzzz.chatwise.Models

import com.jeezzzz.chatwise.Models.SubModels.Product

data class MyProducts(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)