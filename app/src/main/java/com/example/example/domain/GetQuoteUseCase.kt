package com.example.example.domain

import com.example.example.data.QuoteRepository
import com.example.example.data.model.QuoteModel

class GetQuoteUseCase {
    private val repository = QuoteRepository()
    suspend operator fun invoke(): List<QuoteModel> = repository.getAllQuotes()
}