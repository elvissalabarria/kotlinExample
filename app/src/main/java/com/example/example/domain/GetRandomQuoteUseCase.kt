package com.example.example.domain

import com.example.example.data.QuoteRepository
import com.example.example.data.model.QuoteModel
import com.example.example.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val quoteProvider: QuoteProvider
) {
    operator fun invoke(): QuoteModel? {
        val quote = quoteProvider.quotes
        if (quote.isNotEmpty()) {
            val randomNumber = (quote.indices).random()
            return quote[randomNumber]
        }
        return null
    }
}