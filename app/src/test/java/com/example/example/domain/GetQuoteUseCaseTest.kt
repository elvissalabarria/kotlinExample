package com.example.example.domain

import com.example.example.data.QuoteRepository
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Assert.*
import org.junit.Before

class GetQuoteUseCaseTest {
    @RelaxedMockK
    private lateinit var repository: QuoteRepository
    lateinit var getQuoteUseCase: GetQuoteUseCase
    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getQuoteUseCase = GetQuoteUseCase(repository)

    }
}