package com.example.khilendra.mapappkc.source

import com.example.khilendra.mapappkc.data.LocationMelbourne

class DataRepo (private val jsonParsing: JsonParsing) {

    fun getLocations(): ArrayList<LocationMelbourne> {
        return jsonParsing.getLocations()
    }


}