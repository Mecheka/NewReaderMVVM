package com.example.suriya.newreadermvvm.injection.component

import com.example.suriya.newreadermvvm.injection.module.AdapterModule
import com.example.suriya.newreadermvvm.viewmodel.listnews.ListNewsViewModel
import com.example.suriya.newreadermvvm.viewmodel.news.NewsViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AdapterModule::class
))
interface ViewModelInjector {

    fun inject(newsViewModel: NewsViewModel)
    fun inject(listNewsViewModel: ListNewsViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun adapterModule(adapterModule: AdapterModule): Builder
    }
}