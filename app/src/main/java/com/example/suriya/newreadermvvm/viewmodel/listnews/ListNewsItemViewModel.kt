package com.example.suriya.newreadermvvm.viewmodel.listnews

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.content.Intent
import android.view.View
import com.example.suriya.newreadermvvm.view.web.WebsiteActivity
import com.example.suriya.newreadermvvm.model.listnews.ArticleModel
import com.example.suriya.newreadermvvm.util.ISO8601DateParser
import java.text.ParseException
import java.util.*

class ListNewsItemViewModel {

    var imgUrl = MutableLiveData<String>()
    var title = MutableLiveData<String>()
    var dateTime: Date? = null
    var date = MutableLiveData<Date>()
    private var articleModel: ArticleModel? = null
    private var mContext: Context? = null

    fun bind(context: Context, articleModel: ArticleModel) {
        imgUrl.value = articleModel.urlToImage
        title.value = setTitle(articleModel.title)
        date.value = setArtcleTime(articleModel.publishedAt)
        this.articleModel = articleModel
        this.mContext = context
    }

    private fun setArtcleTime(publishedAt: String?): Date? {
        try {
            dateTime = ISO8601DateParser.parse(publishedAt)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return dateTime
    }

    private fun setTitle(title: String?): String {
        return if (title?.length!! > 65) {
            title.substring(0, 65) + "..."
        } else {
            title
        }
    }

    fun onItemClick(view: View) {
        mContext?.let {
            val intent = Intent()
            intent.setClass(mContext, WebsiteActivity::class.java)
            intent.putExtra("url", articleModel?.url)
            it.startActivity(intent)
        }
    }

}