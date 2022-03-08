package com.exchanger.data

import com.exchanger.data.database.ExchangeRateDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val exchangeRateDao: ExchangeRateDao) {


}