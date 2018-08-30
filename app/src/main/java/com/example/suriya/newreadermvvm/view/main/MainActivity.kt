package com.example.suriya.newreadermvvm.view.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.suriya.newreadermvvm.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                    .add(R.id.contentContainer, MainFragment())
                    .commit()
        }

    }
}
