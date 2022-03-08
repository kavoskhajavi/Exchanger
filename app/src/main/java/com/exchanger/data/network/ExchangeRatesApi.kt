package com.exchanger.data.network

import com.exchanger.models.ExchangeRatesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ExchangeRatesApi {


    @GET("/latest")
    fun getRate(@QueryMap rates:Map<String,String>):Response<ExchangeRatesModel>
}