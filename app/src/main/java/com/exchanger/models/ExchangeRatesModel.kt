package com.exchanger.models

import com.google.gson.annotations.SerializedName

data class ExchangeRatesModel(
    @SerializedName("success")
    val success : Boolean,
    @SerializedName("base")
    val base : String,
    @SerializedName("data")
    val data:String,
    @SerializedName("rate")
    val rate:String

)
