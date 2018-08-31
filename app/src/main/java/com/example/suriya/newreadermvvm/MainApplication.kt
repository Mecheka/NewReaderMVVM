package com.example.suriya.newreadermvvm

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.example.suriya.newreadermvvm.di.DaggerAppComponent
import com.example.suriya.newreadermvvm.di.NetworkModule
import dagger.android.*
import javax.inject.Inject

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