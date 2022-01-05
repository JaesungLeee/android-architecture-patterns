package com.jslee.mvvm_example.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy
import com.jslee.mvvm_example.data.local.entity.ShoppingItem


@Dao
interface ShoppingDao {

    @Query("SELECT * FROM shopping_items")
    suspend fun getAllItems(): LiveData<List<ShoppingItem>>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateAndInsertItems(item: ShoppingItem)

    @Delete
    suspend fun deleteItems(item: ShoppingItem)
}