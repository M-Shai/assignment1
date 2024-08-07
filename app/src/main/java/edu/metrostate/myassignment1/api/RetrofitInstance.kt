package edu.metrostate.myassignment1.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object RetrofitInstance {

    private const val BASE_URL = "https://todos.simpleapi.dev/api/"

    private val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        //.add(MoshiAdapter())
        .build()

    val retrofit: ApiCall = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(ApiCall::class.java)

    //val retrofit: ApiCall = data.create(ApiCall::class.java)
}