package com.example.suriya.newreadermvvm.injection.module

import android.arch.lifecycle.ViewModelProvider
import com.example.suriya.newreadermvvm.ViewModelFactory
import com.example.suriya.newreadermvvm.ViewModelKey
import com.example.suriya.newreadermvvm.base.BaseViewModel
import com.example.suriya.newreadermvvm.viewmodel.listnews.ListNewsViewModel
import com.example.suriya.newreadermvvm.viewmodel.news.NewsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    fun newsViewModel(viewModel: NewsViewModel): BaseViewModel

//    @Binds
//    @IntoMap
//    @ViewModelKey(ListNewsViewModel::class)
//    fun listNewsViewModel(viewModel: ListNewsViewModel): BaseViewModel
}