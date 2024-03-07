package com.example.example.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.ui.AppBarConfiguration
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.example.databinding.ActivityMainBinding
import com.example.example.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        quoteViewModel.onCreate()
        quoteViewModel.quoteModel.observe(this, Observer {currentAuthor->
            binding.tvQuote.text = currentAuthor.quote
            binding.tvAuthor.text = currentAuthor.author
        })
        quoteViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })
        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }


}