package com.example.khilendra.mapappkc.source

import com.example.khilendra.mapappkc.data.LocationMelbourne

class DataRepo (private val jsonParsing: JsonParsing) {

    fun getLocations(locationName: String): ArrayList<LocationMelbourne> {
        return jsonParsing.getLocations()
    }


}