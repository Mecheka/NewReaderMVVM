package com.example.suriya.newreadermvvm.view.listnews

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.suriya.newreadermvvm.R
import dagger.android.AndroidInjection

class ListNewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_news)
    }
}
