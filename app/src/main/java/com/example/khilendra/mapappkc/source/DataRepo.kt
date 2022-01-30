package com.example.khilendra.mapappkc.source

import com.example.khilendra.mapappkc.data.LocationMelbourne

class DataRepo (private val jsonParsing: JsonParsing) {

    fun getLocations(locationName: String): ArrayList<LocationMelbourne> {

        //Cal getLocaitons from JsonParsing class and return the locations from there
        return jsonParsing.getLocations()
    }


}