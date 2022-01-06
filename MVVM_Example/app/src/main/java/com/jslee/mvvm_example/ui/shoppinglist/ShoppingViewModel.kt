package com.jslee.mvvm_example.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.jslee.mvvm_example.data.ShoppingRepositoryImpl
import com.jslee.mvvm_example.data.local.entity.ShoppingItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepositoryImpl
) : ViewModel() {

    fun updateAndInsertItems(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.updateAndInsertItems(item)
    }

    fun deleteItems(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.deleteItems(item)
    }

    fun getAllItems() = repository.getAllItems()
}