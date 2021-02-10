package ru.gc986.repository.provider

import retrofit2.Call
import retrofit2.http.GET
import ru.gc986.model.Brand
import ru.gc986.model.wrappers.DataListWrapper
import ru.gc986.model.Store
import ru.gc986.model.wrappers.DataObjWrapper
import ru.gc986.model.wrappers.PaginationWrapper

interface ServerServices {

    @GET("mobile/v1/client/stores")
    fun getStores(): Call<DataListWrapper<Store>>

    @GET("mobile/v1/goods/brands")
    fun getBrands(): Call<DataObjWrapper<PaginationWrapper<Brand>>>

}