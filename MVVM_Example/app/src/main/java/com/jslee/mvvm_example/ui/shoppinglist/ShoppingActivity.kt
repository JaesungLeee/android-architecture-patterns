package com.jslee.mvvm_example.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.jslee.mvvm_example.R
import com.jslee.mvvm_example.data.ShoppingRepositoryImpl
import com.jslee.mvvm_example.data.local.ShoppingDatabase
import com.jslee.mvvm_example.databinding.ActivityShoppingBinding

class ShoppingActivity : AppCompatActivity() {
    private lateinit var database: ShoppingDatabase
    private lateinit var repository: ShoppingRepositoryImpl
    private lateinit var viewModelFactory: ShoppingViewModelFactory

    private val binding: ActivityShoppingBinding by lazy { ActivityShoppingBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        database = ShoppingDatabase(this)
        repository = ShoppingRepositoryImpl(database)
        viewModelFactory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProvider(this)[ShoppingViewModel::class.java]
    }
}