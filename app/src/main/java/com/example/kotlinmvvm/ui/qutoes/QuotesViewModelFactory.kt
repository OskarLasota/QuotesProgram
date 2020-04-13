package com.example.kotlinmvvm.ui.qutoes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinmvvm.data.QuoteRepository

class QuoteViewmodelFactory( private  val quoteRepository: QuoteRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T:ViewModel?> create(modelClass: Class<T>):T{
        return QuotesViewModel(quoteRepository) as T
    }
}