package com.example.suriya.newreadermvvm.view.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.suriya.newreadermvvm.R
import com.example.suriya.newreadermvvm.util.setFragment
import com.example.suriya.newreadermvvm.view.base.BaseActivity
import dagger.android.DaggerActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null){
            setFragment(R.id.contentContainer, ::MainFragment)
        }
    }
}
