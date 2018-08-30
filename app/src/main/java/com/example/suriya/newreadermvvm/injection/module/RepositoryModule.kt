package com.example.suriya.newreadermvvm.injection.module

import com.example.suriya.newreadermvvm.repositories.ListNewsRepositories
import com.example.suriya.newreadermvvm.repositories.NewsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindNewsRepositoty(repository: NewsRepository): NewsRepository

    @Binds
    abstract fun bindListNewsRepository(repository: ListNewsRepositories):ListNewsRepositories
}