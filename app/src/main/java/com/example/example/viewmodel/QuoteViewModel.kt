package com.example.example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.example.model.QuoteModel
import com.example.example.model.QuoteProvider

class QuoteViewModel: ViewModel(){
    val quoteModel = MutableLiveData<QuoteModel>()
    fun randomQuote(){
        val currentQuote=QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }
}