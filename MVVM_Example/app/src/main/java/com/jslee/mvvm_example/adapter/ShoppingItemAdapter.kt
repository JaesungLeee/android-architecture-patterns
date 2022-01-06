package com.jslee.mvvm_example.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jslee.mvvm_example.data.local.entity.ShoppingItem
import com.jslee.mvvm_example.databinding.ItemShoppingBinding
import com.jslee.mvvm_example.holder.ShoppingItemViewHolder
import com.jslee.mvvm_example.ui.shoppinglist.ShoppingViewModel

class ShoppingItemAdapter(
    val context: Context,
    var itemList: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemViewHolder {
        val binding = ItemShoppingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoppingItemViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.bindItems(currentItem)
    }

    override fun getItemCount(): Int = itemList.size
}