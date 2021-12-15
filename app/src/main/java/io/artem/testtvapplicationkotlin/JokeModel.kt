package io.artem.testtvapplicationkotlin

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class JokeModel(
    @SerializedName("content")
    @Expose
    var content: String = ""
) {


}