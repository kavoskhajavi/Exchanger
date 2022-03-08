package com.exchanger.data

import com.exchanger.data.network.ExchangeRatesApi
import com.exchanger.models.ExchangeRatesModel
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val ratesApi: ExchangeRatesApi) {

    fun getRate(rate:Map<String,String>):Response<ExchangeRatesModel>{
        return ratesApi.getRate(rate)
    }

}