package com.example.suriya.newreadermvvm.repositories

import com.example.suriya.newreadermvvm.model.news.Website
import com.example.suriya.newreadermvvm.service.Common
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsRepository{
    fun getNewsData(): Observable<Website> {

        return Common.getNewsService().getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}