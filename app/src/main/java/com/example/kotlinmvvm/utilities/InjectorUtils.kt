package com.example.kotlinmvvm.utilities

import com.example.kotlinmvvm.data.FakeDatabase
import com.example.kotlinmvvm.data.QuoteRepository
import com.example.kotlinmvvm.ui.qutoes.QuoteViewmodelFactory

object InjectorUtils {
    fun provideQuotesViewmodelFactory(): QuoteViewmodelFactory{
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuoteViewmodelFactory(quoteRepository)
    }
}