package com.exchanger.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.exchanger.utils.Constants.Companion.Currency_TABLE


@Entity(tableName = Currency_TABLE)
class CurrencyEntity(
    Id:String,
    Amount:Double,
)
