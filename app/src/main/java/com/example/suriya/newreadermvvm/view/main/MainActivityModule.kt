package com.example.suriya.newreadermvvm.view.main

import com.example.suriya.newreadermvvm.view.listnews.ListNewsActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class MainActivityModule {

    @ContributesAndroidInjector
    internal abstract fun bindMainFragment(): MainFragment
}