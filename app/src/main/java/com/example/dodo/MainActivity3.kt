package com.example.dodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.dodo.adapter.PizzaAdapter
import com.example.dodo.databinding.ActivityMain3Binding
import com.example.dodo.models.FoodItem
import com.example.dodo.models.PizzaDates
import com.example.dodo.models.Pizzas

class MainActivity3 : AppCompatActivity() {


    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getSerializableExtra("pizza") as FoodItem


        // Load image using Glide
        Glide.with(binding.root)
            .load(result.imgUrl)
            .into(binding.pRes)
        binding.resAc3.text = result.title
        binding.pizzzDescription.text = result.shortDescription
        binding.salePizzaBuy.text = "В корзину ${result.buy}₸"


    }

    fun goBack(view: View){
        finish()
    }
}