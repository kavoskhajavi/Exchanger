package com.exchanger.data

import com.exchanger.data.database.ExchangeRateDao
import com.exchanger.data.database.entities.CurrencyEntity
import com.exchanger.data.database.entities.CurrencyExchangesEntity
import com.exchanger.data.database.entities.SettingEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val exchangeRateDao: ExchangeRateDao) {

    suspend fun insertCurrency(currencyEntity: CurrencyEntity){
        exchangeRateDao.insertCurrency(currencyEntity)
    }

    suspend fun insertCurrencyExchanges(currencyExchangesEntity: CurrencyExchangesEntity){
        exchangeRateDao.insertCurrencyExchanges(currencyExchangesEntity)
    }

    suspend fun insertSetting(settingEntity: SettingEntity){
        exchangeRateDao.insertSetting(settingEntity)
    }


}