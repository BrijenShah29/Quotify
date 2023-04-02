package com.example.randomquotes_retrofit_mvvm.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomquotes_retrofit_mvvm.Repository.QuotesRepository
import com.example.randomquotes_retrofit_mvvm.models.QuotesList
import com.example.randomquotes_retrofit_mvvm.models.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: QuotesRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addQuotes()
            repository.getQuotes()
        }
    }

    val quotes : LiveData<List<Result>>
        get() = repository.quotes
}