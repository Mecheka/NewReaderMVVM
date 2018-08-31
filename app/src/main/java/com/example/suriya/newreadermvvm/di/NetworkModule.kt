package com.example.suriya.newreadermvvm.di

import com.example.suriya.newreadermvvm.BuildConfig
import com.example.suriya.newreadermvvm.MainApplication
import com.example.suriya.newreadermvvm.service.INewsService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
open class NetworkModule {

    val BASE_URL: String = "https://newsapi.org"

    open fun buildOkHttpClient(app:MainApplication): OkHttpClient{
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) addInterceptor(logging)
            readTimeout(30, TimeUnit.SECONDS)
        }
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(app:MainApplication): OkHttpClient = buildOkHttpClient(app)

    @Provides
    @Singleton
    @Named("News")
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun providesINewsService(@Named("News")retrofit: Retrofit): INewsService = retrofit.create(INewsService::class.java)
}