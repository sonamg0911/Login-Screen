package com.neosoft.login.screen.loginscreen.network

import com.neosoft.login.screen.loginscreen.BASE_URL
import com.neosoft.login.screen.loginscreen.responses.LoginResponse
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService{

    companion object {

        fun create():ApiService{

            val httpInterceptor = HttpLoggingInterceptor()
            httpInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val httpClient = OkHttpClient.Builder()
                    .addInterceptor(httpInterceptor)
                    .build()

            val retrofit=Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .baseUrl(BASE_URL)
                    .build()

            return retrofit.create(ApiService::class.java)
        }
    }

    @POST("users/login")
    @FormUrlEncoded
    fun login(@Field("email")email:String,@Field("password")password:String):retrofit2.Call<LoginResponse>
}