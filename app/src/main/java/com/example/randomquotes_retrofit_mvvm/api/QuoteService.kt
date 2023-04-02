package com.example.randomquotes_retrofit_mvvm.api

import com.example.randomquotes_retrofit_mvvm.models.QuotesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int) :Response<QuotesList>


}