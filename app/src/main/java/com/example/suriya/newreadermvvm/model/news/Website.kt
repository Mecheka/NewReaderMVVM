package com.example.suriya.newreadermvvm.model.news

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Website {
    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("sources")
    @Expose
    lateinit var sources: ArrayList<Sources>
}