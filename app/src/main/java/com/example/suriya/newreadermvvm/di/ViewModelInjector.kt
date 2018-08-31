package com.example.suriya.newreadermvvm.di

import com.example.suriya.newreadermvvm.viewmodel.listnews.ListNewsViewModel
import com.example.suriya.newreadermvvm.viewmodel.news.NewsViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AdapterModule::class])
interface ViewModelInjector {

    fun inject(viewModel: NewsViewModel)
    fun inject(viewModel: ListNewsViewModel)

    @Component.Builder
    interface Buidler {

        fun adapteModule(adapterModule: AdapterModule): Buidler
        fun build(): ViewModelInjector
    }
}