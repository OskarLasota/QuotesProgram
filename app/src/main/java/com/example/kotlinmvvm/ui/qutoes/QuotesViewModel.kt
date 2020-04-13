package com.example.kotlinmvvm.ui.qutoes

import androidx.lifecycle.ViewModel
import com.example.kotlinmvvm.data.Quote
import com.example.kotlinmvvm.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) :ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote : Quote) = quoteRepository.addQuote(quote)

}