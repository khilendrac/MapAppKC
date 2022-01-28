package com.example.khilendra.mapappkc.data

import com.google.gson.annotations.SerializedName

data class LocationMelbourne(@SerializedName("typeId") var typeId: Int, @SerializedName("departureTime") var departureTime:String,
                             @SerializedName("name") var name:String, @SerializedName("latitude") var latitude:Double,
                             @SerializedName("longitude") var longitude:Double, @SerializedName("isExpress") var isExpress:String,
                             @SerializedName("hasMyKiTopUp") var hasMyKiTopUp:String) {

    override fun toString(): String {
        return name
    }
}