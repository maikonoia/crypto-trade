package br.com.tecdev.btctrade.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
class Transactions (
    @PrimaryKey(autoGenerate = true)
    @SerializedName("_id")
    @ColumnInfo(name = "_id")
    val id: Int,

    @SerializedName("coin")
    @ColumnInfo(name = "coin")
    val coin: String,

    @SerializedName("value")
    @ColumnInfo(name = "value")
    val value: Double,

    @SerializedName("amount")
    @ColumnInfo(name = "amount")
    val amount: Double,

    @SerializedName("sell")
    @ColumnInfo(name = "sell")
    val sell: Double,

    @SerializedName("date")
    @ColumnInfo(name = "date")
    val date: Long
) : Parcelable