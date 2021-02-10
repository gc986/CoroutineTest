package ru.gc986.model

import com.google.gson.annotations.SerializedName

data class Store(
    val name: String,
    @SerializedName("IStoreId")
    val storeId: Int
) {
}