package com.example.example.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.data.model.QuoteModel
import com.example.example.data.model.QuoteProvider
import com.example.example.domain.GetQuoteUseCase
import com.example.example.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()
    var getQuoteUseCase = GetQuoteUseCase()
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuoteUseCase()
            if (result.isNotEmpty()) {
                quoteModel.postValue(result.first())
                isLoading.postValue(false)
            }

        }
    }
    fun randomQuote() {
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        quoteModel.postValue(quote)
        isLoading.postValue(false)

    }
}