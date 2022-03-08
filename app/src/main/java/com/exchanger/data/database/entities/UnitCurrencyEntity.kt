package com.exchanger.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.exchanger.utils.Constants.Companion.UNIT_CURRENCY

@Entity(tableName =UNIT_CURRENCY )
class UnitCurrencyEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var name:String
)
