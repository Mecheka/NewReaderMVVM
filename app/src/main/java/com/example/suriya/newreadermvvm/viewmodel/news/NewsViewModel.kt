package com.example.suriya.newreadermvvm.viewmodel.news

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModel
import com.example.suriya.newreadermvvm.model.news.Sources
import com.example.suriya.newreadermvvm.repositories.NewsRepository
import com.example.suriya.newreadermvvm.view.main.NewsAdapter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class NewsViewModel @Inject constructor(private val reposiroty: NewsRepository) : ViewModel(), LifecycleObserver {

    var newsAdapter: NewsAdapter = NewsAdapter()

    init {
        getNewsList()
    }

    private var compositeDisposeable = CompositeDisposable()

    fun getNewsList() {
        reposiroty.getNewsData()
                .subscribe { website ->
                    setDataToRecyclerView(website.sources)
                }
    }

    private fun setDataToRecyclerView(sources: ArrayList<Sources>) {
        newsAdapter.setSourceData(sources)
    }

    override fun onCleared() {
        compositeDisposeable.clear()
        super.onCleared()
    }
}