package com.example.suriya.newreadermvvm.di

import com.example.suriya.newreadermvvm.repositories.NewsRepository
import com.example.suriya.newreadermvvm.service.INewsService
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class RepositoryModule {

    @Provides
    fun bindNewsRepository(iNewsService: INewsService): NewsRepository = NewsRepository(iNewsService)
}