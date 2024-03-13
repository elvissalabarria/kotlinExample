package com.example.example.domain

import com.example.example.data.QuoteRepository
import com.example.example.data.database.entities.toDatabase
import com.example.example.data.model.QuoteModel
import javax.inject.Inject


class GetQuoteUseCase @Inject constructor(

    private val repository: QuoteRepository
) {
    suspend operator fun invoke(): List<Quote> {

        val quotes = repository.getAllQuotesFromApi()
       return  if (quotes.isNotEmpty()) {
//            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
       quotes
       } else {
            repository.getAllQuotesFromDatabase()
        }
    }
}