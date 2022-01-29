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
import androidx.appcompat.app.AppCompatActivity
import com.example.khilendra.mapappkc.presentation.MainActivity


import kotlin.collections.ArrayList as ArrayList
import java.io.File
import java.nio.channels.AsynchronousFileChannel.open
import java.nio.channels.AsynchronousSocketChannel.open
import java.nio.channels.FileChannel.open
import java.nio.channels.ServerSocketChannel.open

class JsonParsing{


    private lateinit var locations: ArrayList<LocationMelbourne>
    //private lateinit var locs: MutableCollection<ArrayList<LocationMelbourne>>

    fun getLocations(): ArrayList<LocationMelbourne> {


        setLocations()


        return locations

    }
    /*

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

            //val inputStream = assets.open("data.json",0)
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


     */

    private fun setLocations() {
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
            "Flinders",
            -37.8181755,
            144.9661256,
            "true",
            ""
        )
        var loc3: LocationMelbourne = LocationMelbourne(
            0,
            "2021-07-03T14:30:00.000Z",
            "North Melbourne",
            -37.8068073,
            144.9404548,
            "false",
            ""
        )
        var loc4: LocationMelbourne = LocationMelbourne(
            0,
            "2021-07-04T15:35:00.000Z",
            "Upfield",
            -37.5856691,
            145.2270446,
            "true",
            ""
        )
        var loc5: LocationMelbourne = LocationMelbourne(
            0,
            "2021-07-05T11:20:00.000Z",
            "Glen Waverley",
            -37.8794913,
            145.1598501,
            "false",
            ""
        )
        var loc6: LocationMelbourne = LocationMelbourne(
            0,
            "2021-07-05T16:40:00.000Z",
            "Ringwood",
            -37.8153668,
            145.2269614,
            "false",
            ""
        )
        var loc7: LocationMelbourne = LocationMelbourne(
            0,
            "2021-07-06T12:45:00.000Z",
            "Frankston",
            -38.1429773,
            145.1238214,
            "true",
            ""
        )
        var loc8: LocationMelbourne = LocationMelbourne(
            0,
            "2021-07-06T17:45:00.000Z",
            "Werribee",
            -37.8985846,
            144.6590184,
            "true",
            ""
        )
        var loc9: LocationMelbourne = LocationMelbourne(
            1,
            "2021-07-07T13:50:00.000Z",
            "Queen Victoria Market",
            -37.806718,
            144.9574589,
            "",
            "True"
        )
        var loc10: LocationMelbourne = LocationMelbourne(
            1,
            "2021-07-07T18:50:00.000Z",
            "Carlton Gardens",
            -37.8049684,
            144.9572112,
            "",
            "True"
        )
        var loc11: LocationMelbourne = LocationMelbourne(
            1,
            "2021-07-08T14:55:00.000Z",
            "Chadstone Shopping Centre",
            -37.8862515,
            145.0807788,
            "",
            "True"
        )
        var loc12: LocationMelbourne = LocationMelbourne(
            1,
            "2021-07-09T19:55:00.000Z",
            "Monash University",
            -37.8771484,
            145.0427026,
            "",
            "True"
        )
        var loc13: LocationMelbourne = LocationMelbourne(
            0,
            "2021-07-08T16:00:00.000Z",
            "Brighton Beach",
            -37.9265405,
            144.9868176,
            "",
            "False"
        )




        //Adding initial location in the arraylist
        locations = arrayListOf(loc1)

        //Adding additional location to the list
        locations.add(loc2)
        locations.add(loc3)
        locations.add(loc4)
        locations.add(loc5)
        locations.add(loc6)
        locations.add(loc7)
        locations.add(loc8)
        locations.add(loc9)
        locations.add(loc10)
        locations.add(loc11)
        locations.add(loc12)
        locations.add(loc13)



    }



}