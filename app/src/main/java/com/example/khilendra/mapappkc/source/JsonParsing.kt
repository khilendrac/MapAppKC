package com.example.khilendra.mapappkc.source

import android.location.Location
import com.example.khilendra.mapappkc.data.LocationMelbourne
import kotlin.collections.ArrayList as ArrayList

class JsonParsing {


    private lateinit var locations: ArrayList<LocationMelbourne>
    //private lateinit var locs: MutableCollection<ArrayList<LocationMelbourne>>


    fun getLocations(): ArrayList<LocationMelbourne> {

        var counter: Int = 0


        var loc1: LocationMelbourne = LocationMelbourne(
            0,
            "2021-07-03T09:10:00.000Z",
            "Flinders",
            -37.8181755,
            144.9661256,
            "false",
            "false"
        )
        var loc2: LocationMelbourne = LocationMelbourne(
            0,
            "2021-07-03T14:30:00.000Z",
            "North Melbourne",
            -37.8068073,
            144.9404548,
            "True",
            "True"
        )

        //Adding initial location in the arraylist
        locations = arrayListOf(loc1)

        //Adding additional location to the list
        locations.add(loc2)



        return locations

    }
}