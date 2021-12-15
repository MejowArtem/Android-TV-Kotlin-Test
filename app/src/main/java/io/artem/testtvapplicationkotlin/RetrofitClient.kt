package io.artem.testtvapplicationkotlin

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    var retrofit: Retrofit? = null
    var BASE_URL: String? = null
    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}