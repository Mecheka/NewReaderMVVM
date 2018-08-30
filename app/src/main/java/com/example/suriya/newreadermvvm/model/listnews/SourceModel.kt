package com.example.suriya.newreadermvvm.model.listnews

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SourceModel {

    @SerializedName("id")
    @Expose
    var id: Any? = null
    @SerializedName("name")
    @Expose
    var name: String? = null

}
