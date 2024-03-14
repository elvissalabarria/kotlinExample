package com.example.example.domain

import com.example.example.data.QuoteRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetQuoteUseCaseTest {
    @RelaxedMockK
    private lateinit var repository: QuoteRepository
    lateinit var getQuoteUseCase: GetQuoteUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getQuoteUseCase = GetQuoteUseCase(repository)

    }

    @Test
    fun `when use case is invoked then repository is called`(): Unit = runBlocking {

        //Given
        coEvery { repository.getAllQuotesFromApi() } returns emptyList()

        //When
        getQuoteUseCase()

        //Then
        coVerify(exactly = 1) { repository.getAllQuotesFromDatabase() }

    }

    @Test
    fun `when use case is invoked then repository is called and returns a list of quotes`(): Unit =
        runBlocking {

            //Given
            val quotes = listOf(Quote("Quote 1", "Author 1"))
            coEvery { repository.getAllQuotesFromApi() } returns quotes

            //When
            val result = getQuoteUseCase()

            //Then
            coVerify(exactly = 1) { repository.clearQuotes() }
            coVerify(exactly = 1) { repository.insertQuotes(any()) }
            coVerify(exactly = 0) {
                repository.getAllQuotesFromDatabase()
                assertEquals(quotes, result)
            }
        }
}