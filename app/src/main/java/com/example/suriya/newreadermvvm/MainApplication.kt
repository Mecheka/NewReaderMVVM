package com.example.suriya.newreadermvvm

import android.app.Activity
import android.app.Application
import com.example.suriya.newreadermvvm.injection.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MainApplication: Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjection:DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjection
    }

    override fun onCreate() {
        super.onCreate()
        val appComponent = DaggerAppComponent.builder()
                .application(this)
                .build()
        appComponent.inject(this)
    }
}