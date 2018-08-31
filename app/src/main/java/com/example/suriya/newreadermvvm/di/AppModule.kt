package com.example.suriya.newreadermvvm.di

import dagger.Module

@Module(includes = [ViewModelModule::class,
    NetworkModule::class])
class AppModule {


}