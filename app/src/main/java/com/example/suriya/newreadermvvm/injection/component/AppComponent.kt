package com.example.suriya.newreadermvvm.injection.component

import android.app.Application
import com.example.suriya.newreadermvvm.MainApplication
import com.example.suriya.newreadermvvm.injection.module.AppModule
import com.example.suriya.newreadermvvm.injection.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

interface ComponentBuilder<out C> {
    fun build(): C
}

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBinder::class
))
interface AppComponent {

    fun inject(app: MainApplication)

    @Component.Builder
    interface Builder : ComponentBuilder<AppComponent> {

        @BindsInstance
        fun application(application: Application): Builder
    }
}