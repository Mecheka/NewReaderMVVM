package com.example.suriya.newreadermvvm

import android.content.Context
import com.example.suriya.newreadermvvm.di.DaggerAppComponent
import com.example.suriya.newreadermvvm.di.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MainApplication : DaggerApplication() {

    lateinit var androidInjector: AndroidInjector<out DaggerApplication>

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = androidInjector

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        androidInjector = DaggerAppComponent.builder()
                .application(this)
                .network(NetworkModule())
                .build()
    }

}