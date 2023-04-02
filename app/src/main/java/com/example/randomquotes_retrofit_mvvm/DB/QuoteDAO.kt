package com.example.randomquotes_retrofit_mvvm.DB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.randomquotes_retrofit_mvvm.models.Result

@Dao
interface QuoteDAO {

    @Insert
    suspend fun addQuotes(quotes : List<Result>)

    @Query("SELECT * FROM quote")
    suspend fun getQuotes() : List<Result>


}