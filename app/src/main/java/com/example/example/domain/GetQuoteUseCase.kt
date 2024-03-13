package com.example.example.domain

import com.example.example.data.QuoteRepository
import com.example.example.data.model.QuoteModel
import javax.inject.Inject


class GetQuoteUseCase @Inject constructor(

    private val repository: QuoteRepository
) {
    suspend operator fun invoke(): List<QuoteModel> = repository.getAllQuotes()
}