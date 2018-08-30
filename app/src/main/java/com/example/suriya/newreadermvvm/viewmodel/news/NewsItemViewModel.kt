package com.example.suriya.newreadermvvm.viewmodel.news

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.content.Intent
import android.view.View
import com.example.suriya.newreadermvvm.model.news.Sources
import com.example.suriya.newreadermvvm.view.listnews.ListNewsActivity

class NewsItemViewModel : ViewModel() {

    private var adapterPosition: Int? = null
    private var mContext: Context? = null
    private var sources: Sources? = null

    private lateinit var name: MutableLiveData<String>
    private lateinit var strName: String

    fun bind(mContext: Context, sources: Sources) {
        this.mContext = mContext
        this.sources = sources
        this.strName = sources.name.toString()
    }

    fun getSourceName(): String {
        return strName
    }

    fun setAdapterPosition(adapterPosition: Int) {
        this.adapterPosition = adapterPosition
    }

    fun onItemClick(view: View) {
        mContext?.let {
            val intent = Intent()
            intent.setClass(mContext, ListNewsActivity::class.java)
            intent.putExtra("sources", sources)
            it.startActivity(intent)
        }
    }

}