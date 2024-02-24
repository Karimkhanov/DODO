package com.example.dodo.models

import java.io.Serializable
import java.util.UUID

data class Sales(

    override val id: String = UUID.randomUUID().toString(),
    override val title: String,
    override val shortDescription: String,
    override val imgUrl: String,
    override val buy: String,
    override val type: FoodItem.Type = FoodItem.Type.Banner
) : Serializable, FoodItem {
    override fun getListItemType(): Int = FoodItem.Type.Banner.ordinal
}

