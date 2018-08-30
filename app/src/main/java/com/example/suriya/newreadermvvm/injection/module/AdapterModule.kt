package com.example.suriya.newreadermvvm.injection.module

import com.example.suriya.newreadermvvm.view.listnews.ListNewsAdapter
import com.example.suriya.newreadermvvm.view.main.NewsAdapter
import dagger.Module
import dagger.Provides

@Module
class AdapterModule {

    @Provides
    fun providesNewsAdapter():NewsAdapter{
        return NewsAdapter()
    }

    @Provides
    fun providesListNewsAdapter():ListNewsAdapter{
        return ListNewsAdapter()
    }
}