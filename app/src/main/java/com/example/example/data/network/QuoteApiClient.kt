package com.example.example.data.network

import com.example.example.data.model.QuoteModel
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuotes(): List<QuoteModel>
    

}