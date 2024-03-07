package com.example.example.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.ui.AppBarConfiguration
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.example.databinding.ActivityMainBinding
import com.example.example.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        quoteViewModel.quoteModel.observe(this, Observer {currentAuthor->
            binding.tvQuote.text = currentAuthor.quote
            binding.tvAuthor.text = currentAuthor.author
        })
        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }


}