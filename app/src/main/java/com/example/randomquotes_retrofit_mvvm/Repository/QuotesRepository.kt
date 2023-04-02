package com.example.randomquotes_retrofit_mvvm.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.randomquotes_retrofit_mvvm.DB.QuoteDatabase
import com.example.randomquotes_retrofit_mvvm.api.QuoteService
import com.example.randomquotes_retrofit_mvvm.models.QuotesList
import com.example.randomquotes_retrofit_mvvm.models.Result

class QuotesRepository(private val quoteService: QuoteService, private val quoteDatabase: QuoteDatabase) {

    private val quotesLiveData = MutableLiveData<List<Result>>()

    val quotes : LiveData<List<Result>>
        get() = quotesLiveData



    suspend fun addQuotes(){

        var i = 1
        while (i<=3){
        val result = quoteService.getQuotes(i)
        if(result?.body() != null){
            quoteDatabase.quoteDao().addQuotes(result.body()!!.results)
        }
            i+=1
        }
    }

    suspend fun getQuotes(){
        var result = quoteDatabase.quoteDao().getQuotes()
        quotesLiveData.postValue(result)
    }


}