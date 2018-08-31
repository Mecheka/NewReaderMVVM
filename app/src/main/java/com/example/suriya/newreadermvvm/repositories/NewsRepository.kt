package com.example.suriya.newreadermvvm.repositories

import com.example.suriya.newreadermvvm.model.news.Website
import com.example.suriya.newreadermvvm.service.INewsService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewsRepository @Inject constructor(private val iNewsService: INewsService){
    fun getNewsData(): Observable<Website> {

        return iNewsService.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

//        return Common.getNewsService().getNews()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
    }
}