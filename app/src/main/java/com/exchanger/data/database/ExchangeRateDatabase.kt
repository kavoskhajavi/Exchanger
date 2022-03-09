package com.exchanger.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.exchanger.data.database.entities.CurrencyEntity
import com.exchanger.data.database.entities.CurrencyExchangesEntity

@Database(
    entities = [CurrencyEntity::class,CurrencyExchangesEntity::class],
    version = 1,
    exportSchema = false
)

abstract class ExchangeRateDatabase: RoomDatabase() {
    abstract fun exchangeRateDao(): ExchangeRateDao
}