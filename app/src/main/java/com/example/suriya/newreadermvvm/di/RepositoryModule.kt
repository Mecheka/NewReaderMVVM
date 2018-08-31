package com.example.suriya.newreadermvvm.di

import com.example.suriya.newreadermvvm.repositories.ListNewsRepositories
import com.example.suriya.newreadermvvm.repositories.NewsRepository
import com.example.suriya.newreadermvvm.service.INewsService
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun bindNewsRepository(iNewsService: INewsService): NewsRepository = NewsRepository(iNewsService)

    @Provides
    fun bindListNewsRepositoyr(iNewsService: INewsService): ListNewsRepositories = ListNewsRepositories(iNewsService)
}