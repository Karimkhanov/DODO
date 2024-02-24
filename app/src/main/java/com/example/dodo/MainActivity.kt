package com.example.dodo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.bumptech.glide.Glide
import com.example.dodo.databinding.ActivityMainBinding
import com.example.dodo.models.FoodItem
import com.example.hw.Person

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }





        binding.loginButton.setOnClickListener {
            val userName = binding.usernameInput.text.toString()
            val surName = binding.surInput.text.toString()
            val age = binding.birthInput.text.toString()
            val login11 = binding.logInput.text.toString()



            val person = Person(
                user_name = userName,
                sur_name = surName,
                age = age,
                login11 = login11,

            )



            if (validateField(person.user_name, binding.usernameInput, "Enter your name!") &&
                validateField(person.sur_name, binding.surInput, "Enter your surname!") &&
                validateField(person.age, binding.birthInput, "Enter your Age!") &&
                validateField(person.login11, binding.logInput, "Enter your Login!")
            ) {
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                intent.putExtra("Name", person)
                startActivity(intent)
            }
        }




        binding.usernameInput.addTextChangedListener {
            validateField(it.toString(), binding.usernameInput, "Enter your name!")
        }



    }





    private fun validateField(value: String, view: View, errorMessage: String): Boolean {
        return if (value.isEmpty()) {
            view.setBackgroundResource(R.drawable.error)
            (view as? EditText)?.error = errorMessage
            false
        } else {
            view.setBackgroundResource(R.drawable.round)
            (view as? EditText)?.error = null
            true
        }
    }
}