package com.jslee.mvvm_example.data

import androidx.lifecycle.LiveData
import com.jslee.mvvm_example.data.local.entity.ShoppingItem

interface ShoppingRepository {
    fun getAllItems(): LiveData<List<ShoppingItem>>

    suspend fun updateAndInsertItems(item: ShoppingItem)

    suspend fun deleteItems(item: ShoppingItem)
}