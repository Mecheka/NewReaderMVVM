package com.example.suriya.newreadermvvm.service

import com.example.suriya.newreadermvvm.model.listnews.NewsModel
import com.example.suriya.newreadermvvm.model.news.Website
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface INewsService {
    @GET("/v1/sources?language=en")
    fun getNews(): Observable<Website>

    @GET
    fun getNewestArticles(@Url url: String): Observable<NewsModel>
}