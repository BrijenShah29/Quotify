package com.example.randomquotes_retrofit_mvvm

import android.app.Application
import com.example.randomquotes_retrofit_mvvm.DB.QuoteDatabase
import com.example.randomquotes_retrofit_mvvm.Repository.QuotesRepository
import com.example.randomquotes_retrofit_mvvm.api.QuoteService
import com.example.randomquotes_retrofit_mvvm.api.RetrofitHelper

class QuoteApplication : Application() {

    lateinit var quotesRepository: QuotesRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quotesRepository = QuotesRepository(quoteService,database)
    }
}