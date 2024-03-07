package com.example.example.data.network

import com.example.example.core.RetrofitHelper
import com.example.example.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.create

class QuoteService {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response
        }

    }
}