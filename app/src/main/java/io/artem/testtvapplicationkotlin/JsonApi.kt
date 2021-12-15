package io.artem.testtvapplicationkotlin

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

internal interface JsonApi {
    @get:GET("/android/retrofit/data.json")
    val data: Call<List<Any?>?>?

    @GET("/RandJSON.aspx")
    fun getData(@Query("CType") type: Int): Call<JokeModel>

    // for example
    @GET("/api/get")
    fun getData(
        @Query("name") resourceName: String,
        @Query("num") count: Int
    ): Call<List<PostModel?>?>?
}