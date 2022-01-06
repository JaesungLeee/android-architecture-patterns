package com.jslee.mvvm_example.holder

import androidx.recyclerview.widget.RecyclerView
import com.jslee.mvvm_example.data.local.entity.ShoppingItem
import com.jslee.mvvm_example.databinding.ItemShoppingBinding
import com.jslee.mvvm_example.ui.shoppinglist.ShoppingViewModel

class ShoppingItemViewHolder(
    private val binding: ItemShoppingBinding,
    var viewModel: ShoppingViewModel
) : RecyclerView.ViewHolder(binding.root) {

    fun bindItems(currentItem: ShoppingItem) {
        val nameTextView = binding.itemNameTextView
        nameTextView.text = currentItem.name

        val amountTextView = binding.itemAmountTextView
        amountTextView.text = "${currentItem.amount}"

        val deleteButton = binding.itemDeleteImageView
        deleteButton.setOnClickListener {
            viewModel.deleteItems(currentItem)
        }

        val plusButton = binding.itemPlusImageView
        plusButton.setOnClickListener {
            currentItem.amount++
            viewModel.updateAndInsertItems(currentItem)
        }

        val minusButton = binding.itemMinusImageView
        minusButton.setOnClickListener {
            if (currentItem.amount > 0) {
                currentItem.amount--
                viewModel.updateAndInsertItems(currentItem)
            }

        }
    }
}