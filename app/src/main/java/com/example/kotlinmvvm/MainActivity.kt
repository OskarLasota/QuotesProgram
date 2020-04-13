package com.example.kotlinmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinmvvm.data.Quote
import com.example.kotlinmvvm.ui.qutoes.QuotesViewModel
import com.example.kotlinmvvm.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUi()
    }

    private fun initializeUi() {
        // Get the QuotesViewModelFactory with all of it's dependencies constructed
        val factory = InjectorUtils.provideQuotesViewmodelFactory()
        // Use ViewModelProviders class to create / get already created QuotesViewModel
        // for this view (activity)

        val viewModel = ViewModelProvider(this, factory).get(QuotesViewModel::class.java)
        viewModel.getQuotes().observe(this, Observer {
            val stringBuilder = StringBuilder()
            it.forEach{q->
                stringBuilder.append("$q\n\n")
            }
            tv_quotes.text = stringBuilder.toString()
        })


        // When button is clicked, instantiate a Quote and add it to DB through the ViewModel
        add_quote_button.setOnClickListener {
            val quote = Quote(edittext_quote.text.toString(), edittext_author.text.toString())
            viewModel.addQuote(quote)
            edittext_author.setText("")
            edittext_quote.setText("")
        }
    }
}
