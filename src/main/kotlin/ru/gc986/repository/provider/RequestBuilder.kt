package ru.gc986.repository.provider

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.gc986.repository.provider.interceptors.LogJsonInterceptor




class RequestBuilder {

    lateinit var retrofit:Retrofit
    lateinit var service: ServerServices

    fun build():RequestBuilder{
        val httpClient = OkHttpClient.Builder()
//        httpClient.addInterceptor(LogJsonInterceptor())

        retrofit = Retrofit.Builder()
            .baseUrl("https:/i-dev.api.kari.com/")
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

         service = retrofit.create(ServerServices::class.java)
        return this
    }
}