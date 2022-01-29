package com.example.khilendra.mapappkc.source

import com.example.khilendra.mapappkc.data.LocationMelbourne


import kotlin.collections.ArrayList as ArrayList

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.File



class JsonParsing{


    private lateinit var locations: ArrayList<LocationMelbourne>
    //private lateinit var locs: MutableCollection<ArrayList<LocationMelbourne>>

    fun getLocations(): ArrayList<LocationMelbourne> {


        setLocations()


        return locations

    }
    /*


    fun test() {
        val mapper = jacksonObjectMapper()
        mapper.registerKotlinModule()
        mapper.registerModule(JavaTimeModule())

        val jsonString: String = File("/src/main/resources/data.json").readText(Charsets.UTF_8)
        val jsonTextList:List<LocationMelbourne> = mapper.readValue<List<LocationMelbourne>>(jsonString)
        for (film in jsonTextList) {

        }

    }

     */
/*

    private fun handleJson(jsonString: String?) {

        val jsonArray = JSONArray(jsonString)
        val list: ArrayList<LocationMelbourne> = ArrayList<LocationMelbourne>()


        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            list.add(LocationMelbourne(
                jsonObject.getInt("typeId"),
                jsonObject.getString("departureTime"),
                jsonObject.getString("name"),
                jsonObject.getDouble("latitude"),
                jsonObject.getDouble("longitude"),
                jsonObject.getString("isExpress"),
                jsonObject.getString("hasMyKiTopUp")

            ))

        }

        locations = list


    }



 */





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
            "",
            ""
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
            "true"
        )
        var loc10: LocationMelbourne = LocationMelbourne(
            1,
            "2021-07-07T18:50:00.000Z",
            "Carlton Gardens",
            -37.8049684,
            144.9572112,
            "",
            "true"
        )
        var loc11: LocationMelbourne = LocationMelbourne(
            1,
            "2021-07-08T14:55:00.000Z",
            "Chadstone Shopping Centre",
            -37.8862515,
            145.0807788,
            "",
            "true"
        )
        var loc12: LocationMelbourne = LocationMelbourne(
            1,
            "2021-07-09T19:55:00.000Z",
            "Monash University",
            -37.8771484,
            145.0427026,
            "",
            "true"
        )
        var loc13: LocationMelbourne = LocationMelbourne(
            1,
            "2021-07-08T16:00:00.000Z",
            "Brighton Beach",
            -37.9265405,
            144.9868176,
            "",
            "false"
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


