package com.example.dodo
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.dodo.adapter.PizzaAdapter
import com.example.dodo.databinding.ActivityMain2Binding
import com.example.dodo.models.FoodItem
import com.example.dodo.models.PizzaDates


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val adapter = PizzaAdapter(
            onPizzaClick = {
//                Toast.makeText(this, it.title, Toast.LENGTH_SHORT).show()
                handlePizzaClick(it)
            }
        )

        binding.recView.adapter = adapter

        adapter.setData(PizzaDates.pizzaList)





        binding.search.addTextChangedListener{
            val searchQuery = it.toString().lowercase()

            if (searchQuery.isEmpty()){
                adapter.setData(PizzaDates.pizzaList)
            }else{
                val list = PizzaDates.pizzaList.filter {
                    it.title.lowercase().contains(searchQuery)
                }
                adapter.setData(ArrayList(list))
            }
        }


    }

        private fun handlePizzaClick(pizzas: FoodItem) {
        val intent = Intent(this, MainActivity3::class.java)
        intent.putExtra("pizza", pizzas)
        startActivity(intent)
    }
}





