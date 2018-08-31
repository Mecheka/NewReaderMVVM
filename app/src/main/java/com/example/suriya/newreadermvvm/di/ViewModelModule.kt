package com.example.suriya.newreadermvvm.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.suriya.newreadermvvm.viewmodel.news.NewsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [RepositoryModule::class])
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    fun bindNewsViewModel(viewModel: NewsViewModel): ViewModel
}