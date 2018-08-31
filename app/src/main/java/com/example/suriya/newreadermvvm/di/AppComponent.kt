package com.example.suriya.newreadermvvm.di

import com.example.suriya.newreadermvvm.MainApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBinder::class,
    AppModule::class])
interface AppComponent : AndroidInjector<MainApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: MainApplication): Builder

        fun network(network: NetworkModule): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: MainApplication?)
}