package com.example.suriya.newreadermvvm.model.listnews

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NewsModel {

    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("source")
    @Expose
    var source: String? = null
    @SerializedName("sortBy")
    @Expose
    var sortBy: String? = null
    @SerializedName("articles")
    @Expose
    var articles: ArrayList<ArticleModel>? = null
}
