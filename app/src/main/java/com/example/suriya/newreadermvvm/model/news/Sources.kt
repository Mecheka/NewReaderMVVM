package com.example.suriya.newreadermvvm.model.news

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class UrlsToLogos : Serializable {

    @SerializedName("small")
    @Expose
    var small: String? = null
    @SerializedName("medium")
    @Expose
    var medium: String? = null
    @SerializedName("large")
    @Expose
    var large: String? = null

}

class Sources : Serializable {

    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("category")
    @Expose
    var category: String? = null
    @SerializedName("language")
    @Expose
    var language: String? = null
    @SerializedName("country")
    @Expose
    var country: String? = null
    @SerializedName("urlsToLogos")
    @Expose
    var urlsToLogos: UrlsToLogos? = null
    @SerializedName("sortBysAvailable")
    @Expose
    var sortBysAvailable: List<String>? = null
}
