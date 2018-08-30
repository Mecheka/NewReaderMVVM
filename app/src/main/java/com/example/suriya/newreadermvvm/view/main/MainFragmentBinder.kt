package com.example.suriya.newreadermvvm.view.main

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBinder {

    @ContributesAndroidInjector(modules = arrayOf(
            MainFragmetnModule::class
    ))
    abstract fun bindMainFragment(): MainFragment

}