package com.example.dodo.models

import java.io.Serializable


interface FoodItem : Serializable {
    enum class Type { Pizza, Banner }

    fun getListItemType(): Int

    val type: Type
    val id: String
    val title: String
    val shortDescription: String
    val imgUrl: String
    val buy: String
}

