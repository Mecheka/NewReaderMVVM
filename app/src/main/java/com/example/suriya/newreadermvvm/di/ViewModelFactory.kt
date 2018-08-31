package com.example.suriya.newreadermvvm.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * Created by Wasabeef on 2018/03/05.
 */
@Singleton
class ViewModelFactory @Inject constructor(
        private val creators: Map<Class<out ViewModel>,
                @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass as Class<ViewModel>]
                ?: creators.entries.firstOrNull {
                    (c, _) -> modelClass.isAssignableFrom(c)
                }?.value ?: throw IllegalArgumentException("Unknown model class $modelClass") as Throwable

        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }
}