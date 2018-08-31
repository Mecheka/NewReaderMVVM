package com.example.suriya.newreadermvvm.view.listnews

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ListNewsActivityModule {

    @ContributesAndroidInjector
    internal abstract fun bindListNewsFragment(): ListNewsFragment
}