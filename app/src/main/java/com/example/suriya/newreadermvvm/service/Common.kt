package com.example.suriya.newreadermvvm.service

import com.example.suriya.newreadermvvm.util.Constants.Companion.API_KEY

class Common {
    companion object {
        fun getNewsService(): INewsService {
            return RetrofitClient.create().create(INewsService::class.java)
        }

        fun getIconBetterService(): IIconBetterIdeaService {
            return IconBetterIdeaClient.create().create(IIconBetterIdeaService::class.java)
        }

        fun getApiKey(source: String, apiKey: String): String {
            val apiUrl = StringBuilder("https://newsapi.org/v1/articles?source=")
            return apiUrl.append(source)
                    .append("&apiKey=")
                    .append(API_KEY)
                    .toString()
        }
    }
}