package com.example.suriya.newreadermvvm.di

import com.example.suriya.newreadermvvm.view.listnews.ListNewsAdapter
import com.example.suriya.newreadermvvm.view.main.NewsAdapter
import dagger.Module
import dagger.Provides

@Module
@Suppress("unused")
class AdapterModule {

    @Provides
    fun providesNewsAdapter(): NewsAdapter = NewsAdapter()

    @Provides
    fun providesListNewsAdapter(): ListNewsAdapter = ListNewsAdapter()

}