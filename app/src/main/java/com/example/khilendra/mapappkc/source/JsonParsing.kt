package com.example.khilendra.mapappkc.source
import android.content.Context
import com.example.khilendra.mapappkc.data.LocationMelbourne
import kotlin.collections.ArrayList as ArrayList
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset


class JsonParsing{

    //ArrayList of the locations which is passed to GoogleMapFragment via View Model
    private lateinit var locations: ArrayList<LocationMelbourne>


    //This object receives Context from container in order to access the json file from assets folder
    companion object {
        private lateinit var context: Context
        fun setContext(con: Context) {
            context=con
        }
    }



    //Main function which returns the locations to model view
    fun getLocations(): ArrayList<LocationMelbourne> {
        //setLocations()

        //function to read the json file
        readJSON()

        //Finally return the locations
        return locations
    }


    private fun readJSON() {

        //Declaring list and objects

        var list: ArrayList<LocationMelbourne> = ArrayList<LocationMelbourne>()
        lateinit var loc:LocationMelbourne
        try {
            //Getting json object from LoadJSONFromAsset function and assigning it to array
            val obj = JSONObject(loadJSONFromAsset())
            val userArray = obj.getJSONArray("data")

            //Looping for each objects in array and assigning them into variables
            for (i in 0 until userArray.length()) {
                val jsonObject = userArray.getJSONObject(i)


                var typeId = jsonObject.getInt("typeId")
                var departureTime = jsonObject.getString("departureTime")
                var name = jsonObject.getString("name")
                var latitude = jsonObject.getDouble("latitude")
                var longitude = jsonObject.getDouble("longitude")


                //These three values are sometimes not present in json file therefore initializing them with blank
                var isExpress:String = ""
                var hasMyKiTopUp:String = ""
                var route:String = ""

                //Implementing try catch for those three values and assigning them "" value when they are not present in json file
                try{
                    isExpress = jsonObject.getString("isExpress")
                } catch (e: JSONException) {
                        isExpress = ""
                }
                try{
                    hasMyKiTopUp = jsonObject.getString("hasMyKiTopUp")
                } catch (e: JSONException) {
                    hasMyKiTopUp = ""
                }
                try{
                    route = jsonObject.getString("route")
                } catch (e: JSONException) {
                    route = ""
                }

                // creating location object from above details for a single line
                loc = LocationMelbourne(
                    typeId,
                    departureTime,
                    name,
                    latitude,
                    longitude,
                    isExpress,
                    hasMyKiTopUp
                )


                //Logic to know if it is running for the first time
                if(i==0) {
                    //if first time, create an array list of the object
                    list = arrayListOf(loc)
                } else {
                    //if not the first time, add the location object to the list
                    list.add(loc)

                }
            }

            //Finally assign the list to the main list accessible to return
            locations = list
        }
        catch (e: JSONException) {
            e.printStackTrace()
        }
    }


    //Function to load the json file and return object
    private fun loadJSONFromAsset(): String {
        val json: String?
        try {
            //This is the context which was passed from google map fragment
            val inputStream = context.assets.open("data.json")
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





    //Manually set up the location details in order to run the program when I was having issues with reading json file
    //Not using this anymore, just left for a reference
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


