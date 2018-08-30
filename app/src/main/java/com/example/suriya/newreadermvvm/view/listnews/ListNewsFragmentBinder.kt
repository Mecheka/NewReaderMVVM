package com.example.suriya.newreadermvvm.view.listnews

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ListNewsFragmentBinder {

    @ContributesAndroidInjector(modules = arrayOf(
            ListNewsFragmentModule::class
    ))
    abstract fun bindListNewsFragment(): ListNewsFragment
}