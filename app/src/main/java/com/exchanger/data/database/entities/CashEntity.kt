package com.exchanger.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.exchanger.utils.Constants.Companion.CASH_TABLE

@Entity(tableName = CASH_TABLE)
class CashEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var cash: Long,
    var unitId: Int
)
