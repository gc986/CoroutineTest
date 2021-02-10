package ru.gc986.repository.provider

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.gc986.model.Brand
import ru.gc986.model.wrappers.DataObjWrapper
import ru.gc986.model.wrappers.PaginationWrapper

interface ServerServices {

    @GET("mobile/v1/goods/brands")
    fun getBrandsCall(): Call<DataObjWrapper<PaginationWrapper<Brand>>>

    @GET("mobile/v1/goods/brands")
    suspend fun getBrands(@Query("page") page: Int): Response<DataObjWrapper<PaginationWrapper<Brand>>>

}