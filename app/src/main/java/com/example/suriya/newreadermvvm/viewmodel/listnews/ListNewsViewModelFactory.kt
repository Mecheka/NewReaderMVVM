package com.example.suriya.newreadermvvm.viewmodel.listnews

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.suriya.newreadermvvm.model.news.Sources
import com.example.suriya.newreadermvvm.repositories.ListNewsRepositories

class ListNewsViewModelFactory(val repository: ListNewsRepositories, val sources: Sources)
    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListNewsViewModel(repository, sources) as T
    }
}