package io.artem.testtvapplicationkotlin

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class PostModel {
    @SerializedName("site")
    @Expose
    var site: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("desc")
    @Expose
    var desc: String? = null

    @SerializedName("link")
    @Expose
    var link: Any? = null

    @SerializedName("elementPureHtml")
    @Expose
    var elementPureHtml: String? = null
}