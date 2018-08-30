package com.example.suriya.newreadermvvm.base

import android.arch.lifecycle.ViewModel
import com.example.suriya.newreadermvvm.injection.component.DaggerViewModelInjector
import com.example.suriya.newreadermvvm.injection.module.AdapterModule
import com.example.suriya.newreadermvvm.viewmodel.listnews.ListNewsViewModel
import com.example.suriya.newreadermvvm.viewmodel.news.NewsViewModel

open class BaseViewModel:ViewModel(){

    private val injector = DaggerViewModelInjector
            .builder()
            .adapterModule(AdapterModule())
            .build()

    init {
        inject()
    }

    private fun inject() {
        when(this){
            is NewsViewModel -> injector.inject(this)
            is ListNewsViewModel -> injector.inject(this)
        }
    }
}