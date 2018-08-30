package com.example.suriya.newreadermvvm

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import com.example.suriya.newreadermvvm.base.BaseViewModel
import javax.inject.Inject

inline fun <reified T : BaseViewModel> Fragment.getViewModel(viewModelFactory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, viewModelFactory)[T::class.java]
}

inline fun <reified T : BaseViewModel> Fragment.withViewModel(viewModelFactory: ViewModelProvider.Factory, body:T.()->Unit):T{
    val vm = getViewModel<T>(viewModelFactory)
    vm.body()
    return vm
}