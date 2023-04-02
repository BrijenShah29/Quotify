package com.example.randomquotes_retrofit_mvvm.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.randomquotes_retrofit_mvvm.Repository.QuotesRepository

class MainViewModelFactory(private val repository: QuotesRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}