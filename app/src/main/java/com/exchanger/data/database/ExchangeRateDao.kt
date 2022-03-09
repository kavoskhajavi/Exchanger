package com.exchanger.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.exchanger.data.database.entities.CurrencyEntity
import com.exchanger.data.database.entities.CurrencyExchangesEntity
import com.exchanger.data.database.entities.SettingEntity

@Dao
interface ExchangeRateDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrency(currencyEntity: CurrencyEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrencyExchanges(currencyExchangesEntity: CurrencyExchangesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSetting(settingEntity: SettingEntity)

}