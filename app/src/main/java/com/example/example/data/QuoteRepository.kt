package com.example.example.data

import com.example.example.data.model.QuoteModel
import com.example.example.data.model.QuoteProvider
import com.example.example.data.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()
    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }

}