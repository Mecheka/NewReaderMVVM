package com.example.suriya.newreadermvvm.service

import com.example.suriya.newreadermvvm.model.news.IconBetterIdea
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface IIconBetterIdeaService {
    @GET
    fun getIconUrl(@Url url: String): Observable<IconBetterIdea>
}