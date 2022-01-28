package com.example.khilendra.mapappkc.source

import android.content.Context
import android.hardware.Camera.open
import android.location.Location
import android.os.ParcelFileDescriptor.open
import android.system.Os.open
import com.example.khilendra.mapappkc.data.LocationMelbourne
import org.json.JSONObject
import java.io.InputStream
import org.json.JSONException
import java.io.IOException
import java.nio.charset.Charset
import android.os.Bundle


import kotlin.collections.ArrayList as ArrayList
import java.io.File
import java.nio.channels.AsynchronousFileChannel.open
import java.nio.channels.AsynchronousSocketChannel.open
import java.nio.channels.FileChannel.open
import java.nio.channels.ServerSocketChannel.open

class JsonParsing {


    private lateinit var locations: ArrayList<LocationMelbourne>
    //private lateinit var locs: MutableCollection<ArrayList<LocationMelbourne>>

    fun getLocations(): ArrayList<LocationMelbourne> {

        var counter: Int = 0

        readJSON()


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

    private fun readJSON() {

        try {
            val obj = JSONObject(loadJSONFromAsset())
            val userArray = obj.getJSONArray("users")
            for (i in 0 until userArray.length()) {

            }
        }
        catch (e: JSONException) {
            e.printStackTrace()
        }
    }




    private fun loadJSONFromAsset(): String {
        val json: String?
        try {
            val inputStream = assets.open("data.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        }
        catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }



}