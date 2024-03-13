package com.example.example.domain

import com.example.example.data.database.entities.QuoteEntity
import com.example.example.data.model.QuoteModel

data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)