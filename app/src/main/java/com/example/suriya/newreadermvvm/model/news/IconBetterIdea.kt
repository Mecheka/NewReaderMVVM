package com.example.suriya.newreadermvvm.model.news

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class IconBetterIdea {
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("icons")
    @Expose
    var iconList: List<Icon>? = null
}