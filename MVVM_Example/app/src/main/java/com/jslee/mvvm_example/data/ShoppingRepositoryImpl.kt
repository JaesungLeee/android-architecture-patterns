package com.jslee.mvvm_example.data


import com.jslee.mvvm_example.data.local.ShoppingDatabase
import com.jslee.mvvm_example.data.local.entity.ShoppingItem

class ShoppingRepositoryImpl(private val db: ShoppingDatabase) : ShoppingRepository {
    override fun getAllItems() = db.getShoppingDao().getAllItems()

    override suspend fun updateAndInsertItems(item: ShoppingItem) {
        db.getShoppingDao().updateAndInsertItems(item)
    }

    override suspend fun deleteItems(item: ShoppingItem) {
        db.getShoppingDao().deleteItems(item)
    }
}