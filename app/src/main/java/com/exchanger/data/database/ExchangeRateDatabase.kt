package com.exchanger.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.exchanger.data.database.entities.CashEntity
import com.exchanger.data.database.entities.UnitCurrencyEntity

@Database(
    entities = [CashEntity::class,UnitCurrencyEntity::class],
    version = 1,
    exportSchema = false
)

abstract class ExchangeRateDatabase: RoomDatabase() {
    abstract fun exchangeRateDao(): ExchangeRateDao
}