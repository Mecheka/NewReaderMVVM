package com.example.suriya.newreadermvvm.model.news

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Icon {

    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("width")
    @Expose
    var width: Int? = null
    @SerializedName("height")
    @Expose
    var height: Int? = null
    @SerializedName("format")
    @Expose
    var format: String? = null
    @SerializedName("bytes")
    @Expose
    var bytes: Int? = null
    @SerializedName("error")
    @Expose
    var error: Any? = null
    @SerializedName("sha1sum")
    @Expose
    var shalsum: String? = null

}
