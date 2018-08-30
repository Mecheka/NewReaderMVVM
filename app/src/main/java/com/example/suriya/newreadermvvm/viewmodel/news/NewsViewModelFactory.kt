package com.example.suriya.newreadermvvm.viewmodel.news

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.suriya.newreadermvvm.repositories.NewsRepository

class NewsViewModelFactory(private val repository: NewsRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(repository) as T
    }
}