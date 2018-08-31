package com.example.suriya.newreadermvvm.view.listnews

import android.os.Bundle
import com.example.suriya.newreadermvvm.R
import com.example.suriya.newreadermvvm.util.setFragment
import com.example.suriya.newreadermvvm.base.BaseActivity

class ListNewsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_news)
        if(savedInstanceState == savedInstanceState){
            setFragment(R.id.contentContainer, ::ListNewsFragment)
        }
    }
}
