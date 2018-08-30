package com.example.suriya.newreadermvvm.repositories

import com.example.suriya.newreadermvvm.model.listnews.NewsModel
import com.example.suriya.newreadermvvm.model.news.Sources
import com.example.suriya.newreadermvvm.service.Common
import com.example.suriya.newreadermvvm.util.Constants.Companion.API_KEY
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListNewsRepositories {

    fun loadNews(sources: Sources): Observable<NewsModel> {

        return Common.getNewsService().getNewestArticles(Common.getApiKey(sources.id!!,
                API_KEY))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

    }

}