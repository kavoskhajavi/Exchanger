package com.exchanger.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.exchanger.utils.Constants.Companion.Currency_Exchanges_TABLE


@Entity(tableName = Currency_Exchanges_TABLE)
class CurrencyExchangesEntity(
    @PrimaryKey(autoGenerate = true)
    var Id: Int,
    var IdCurrencySeller: String,
    var SellingPrice: Double,
    var IdCurrencyReceiver: String,
    var ReceivePrice: Double,
    var CommissionFee: Double,
    var FinalSellingPrice: Double,
    var FinalReceivePrice: Double,
    var Date: String
)
