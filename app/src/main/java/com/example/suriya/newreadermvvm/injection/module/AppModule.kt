package com.example.suriya.newreadermvvm.injection.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(
        RepositoryModule::class,
        NetworkModule::class
))
class AppModule {

    @Provides
    fun providesContext(application: Application): Context = application
}