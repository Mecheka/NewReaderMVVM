package com.example.suriya.newreadermvvm.view.listnews

import com.example.suriya.newreadermvvm.repositories.ListNewsRepositories
import dagger.Module
import dagger.Provides

@Module
class ListNewsFragmentModule{

    @Provides
    fun providesRepo():ListNewsRepositories{
        return ListNewsRepositories()
    }
}