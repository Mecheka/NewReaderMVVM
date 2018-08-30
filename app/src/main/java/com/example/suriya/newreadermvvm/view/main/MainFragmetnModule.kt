package com.example.suriya.newreadermvvm.view.main

import com.example.suriya.newreadermvvm.repositories.NewsRepository
import dagger.Module
import dagger.Provides

@Module
class MainFragmetnModule{

    @Provides
    fun providesRepo():NewsRepository{
        return NewsRepository()
    }
}