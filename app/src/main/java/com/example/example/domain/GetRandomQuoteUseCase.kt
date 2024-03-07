package com.example.example.domain

import com.example.example.data.QuoteRepository
import com.example.example.data.model.QuoteModel
import com.example.example.data.model.QuoteProvider

class GetRandomQuoteUseCase {
    operator fun invoke(): QuoteModel? {
        val quote = QuoteProvider.quotes
        if (quote.isNotEmpty()) {
            val randomNumber = (quote.indices).random()
            return quote[randomNumber]
        }
        return null
    }
}