package com.example.suriya.newreadermvvm.injection.component

import com.example.suriya.newreadermvvm.view.listnews.ListNewsActivityModule
import com.example.suriya.newreadermvvm.view.main.MainActivityModule
import com.example.suriya.newreadermvvm.view.main.MainFragmentBinder
import com.example.suriya.newreadermvvm.view.listnews.ListNewsActivity
import com.example.suriya.newreadermvvm.view.listnews.ListNewsFragmentBinder
import com.example.suriya.newreadermvvm.view.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinder {

    @ContributesAndroidInjector(modules = arrayOf(
            MainActivityModule::class,
            MainFragmentBinder::class
    ))
    abstract fun bindMainActivity(): MainActivity
    @ContributesAndroidInjector(modules = arrayOf(
            ListNewsActivityModule::class,
            ListNewsFragmentBinder::class
    ))
    abstract fun bindListNewsActivity(): ListNewsActivity
}