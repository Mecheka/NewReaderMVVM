package com.example.suriya.newreadermvvm.view.web

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.suriya.newreadermvvm.R
import com.example.suriya.newreadermvvm.databinding.WebsiteActivityBinding

class WebsiteActivity : AppCompatActivity() {

    private lateinit var binding: WebsiteActivityBinding
    var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_website)
        binding.setLifecycleOwner(this)

        binding.viewControl = this
        intent.getStringExtra("url")?.let {
            url = it
        }
    }
}
