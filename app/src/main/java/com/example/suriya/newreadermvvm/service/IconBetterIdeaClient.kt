package com.example.suriya.newreadermvvm.service

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class IconBetterIdeaClient{
    companion object {
        fun create():Retrofit{
            return Retrofit.Builder()
                    .baseUrl("https://i.olsh.me")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
    }
}