package com.example.suriya.newreadermvvm.di

import com.example.suriya.newreadermvvm.view.listnews.ListNewsActivity
import com.example.suriya.newreadermvvm.view.listnews.ListNewsActivityModule
import com.example.suriya.newreadermvvm.view.main.MainActivity
import com.example.suriya.newreadermvvm.view.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBinder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [ListNewsActivityModule::class])
    internal abstract fun bindListNewsActivity(): ListNewsActivity
}