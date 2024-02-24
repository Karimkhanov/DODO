package com.example.dodo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dodo.R
import com.example.dodo.databinding.PizzaItemsBinding
import com.example.dodo.databinding.SalePizzaBinding
import com.example.dodo.models.FoodItem

class PizzaAdapter(
    private val onPizzaClick: (FoodItem) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val pizzaList: ArrayList<FoodItem> = ArrayList()

    fun setData(pizazz: ArrayList<FoodItem>) {
        pizzaList.clear()
        pizzaList.addAll(pizazz)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            FoodItem.Type.Pizza.ordinal -> ViewHolderPizza(
                PizzaItemsBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            FoodItem.Type.Banner.ordinal -> ViewHolderSale(
                SalePizzaBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount() = pizzaList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolderPizza -> holder.bind(pizzaList[position])
            is ViewHolderSale -> holder.bind(pizzaList[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return pizzaList[position].getListItemType()
    }

    inner class ViewHolderPizza(
        private val binding: PizzaItemsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(foodItem: FoodItem) {
            with(binding) {
                Glide.with(root.context)
                    .load(foodItem.imgUrl)
                    .placeholder(R.drawable.baseline_aspect_ratio_24)
                    .into(pizzaImage)

                pizzaTitle.text = foodItem.title
                pizzaDescription.text = foodItem.shortDescription
                pizzaBuy.text = foodItem.buy

                root.setOnClickListener {
                    onPizzaClick(foodItem)
                }
            }
        }
    }

    inner class ViewHolderSale(
        private val binding: SalePizzaBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(foodItem: FoodItem) {
            with(binding) {
                Glide.with(root.context)
                    .load(foodItem.imgUrl)
                    .placeholder(R.drawable.baseline_aspect_ratio_24)
                    .into(salesRes)

                saleTitle.text = foodItem.title
                saleDescription.text = foodItem.shortDescription
                salePizzaBuy.text = foodItem.buy

                root.setOnClickListener {
                    onPizzaClick(foodItem)
                }
            }
        }
    }
}
