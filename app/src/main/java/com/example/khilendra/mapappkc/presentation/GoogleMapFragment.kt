package com.example.khilendra.mapappkc.presentation

import com.example.khilendra.mapappkc.MainViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.khilendra.mapappkc.R
import com.example.khilendra.mapappkc.data.LocationMelbourne
import com.example.khilendra.mapappkc.source.JsonParsing
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.timepicker.TimeFormat
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.logging.SimpleFormatter
import kotlin.collections.ArrayList



class GoogleMapFragment : Fragment() {

    private lateinit var mMap : GoogleMap
    private var mapReady = false

    //Values being received from main screen
    private lateinit var transportType: String
    private lateinit var expressOrNot: String
    private lateinit var hasMykiTopUpOrNot: String

    private lateinit var locations: ArrayList<LocationMelbourne>
    private lateinit var viewModel : MainViewModel




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_google_map, container, false)


        //Receiving the data from the initial screen
        transportType = requireArguments().getString("transType").toString()
        expressOrNot = requireArguments().getString("expressOrNot").toString()
        hasMykiTopUpOrNot = requireArguments().getString("hasMykiTopUp").toString()


        //Changing the values in order to work with logics
        if(expressOrNot=="Yes") {
            expressOrNot = "true"

        } else {
            expressOrNot = "false"

        }


        if(hasMykiTopUpOrNot=="Yes") {
            hasMykiTopUpOrNot = "true"

        } else {
            hasMykiTopUpOrNot = "false"

        }


        //Passing the context from container to JsonParsing class in order to use the json file from assets folder
        if (container != null) {
            JsonParsing.Companion.setContext(container.getContext())
        }


        //Configuring the view model
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        //Getting locations as arraylist from the view model
        locations = viewModel.locations


        val mapFragment = childFragmentManager.findFragmentById(R.id.googleMapFragment) as SupportMapFragment

        //syncing with the map
        mapFragment.getMapAsync {
                googleMap -> mMap = googleMap
            mapReady = true
            updateMap()
        }


        return rootView
    }









    //Function ot update the map
    private fun updateMap() {

        //Initializing some variables required for the map
        var transportationType: String

        var currentDate = LocalDate.now()
        var currentTime = LocalTime.now()



        var transType: Int
        var departureTime: String
        var name: String
        var latitude: Double
        var longitude: Double
        var isExpress: String
        var hasMyki: String

        var counter: Int = 0

        //Run the code only when the map is ready
        if(mapReady) {

            //Pulling details from the arraylist grabbed from the view model
            locations.forEach {
                location ->
                latitude = location.latitude
                longitude = location.longitude
                name = location.name
                departureTime = location.departureTime
                isExpress = location.isExpress
                hasMyki = location.hasMyKiTopUp
                transType = location.typeId


                //Logic to set the transportation type from id as integer
                if (transType == 0) {
                    transportationType = "Train"

                } else {
                    transportationType = "Tram"
                }


                //Logic to set isExpress and hasMykiTopUp from boolean types

                if(isExpress == "") {
                    isExpress = "false"
                }
                if(hasMyki == "") {
                    hasMyki = "false"
                }


                //Getting the time zone and setting it up
                val dt = ZonedDateTime.parse(departureTime)

                //Formatting the date and time to display in the map
                var timeFormatter = DateTimeFormatter.ofPattern("hh:mm a")
                var time = dt.format(timeFormatter)


                var dtime = currentTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT))

                var dayFormatter = DateTimeFormatter.ofPattern("dd")
                var day = dt.format(dayFormatter).toInt()


                var pattern = "dd MM YYYY"
                val suffix = getDayOfMonthSuffix(day)


                //Setting up the suffix for the date
                if(suffix == "st") {
                    pattern = "d'st' MMM YYYY"

                } else if (suffix == "th") {
                    pattern = "d'th' MMM YYYY"

                } else if (suffix == "nd") {
                    pattern = "d'nd' MMM YYYY"

                } else if (suffix == "rd") {
                    pattern = "d'rd' MMM YYYY"

                }

                //Formatting the date
                var dateFormatter = DateTimeFormatter.ofPattern(pattern)

                var date = dt.format(dateFormatter)



                //Condition to check if the user selection from the screen matches the data from json file fetched via Model View
                if(transportType == transportationType && expressOrNot == isExpress && hasMykiTopUpOrNot == hasMyki) {
                    //Setting up the latitudes and longitudes
                    val marker = LatLng(latitude,longitude)
                    //Positioning the map

                    mMap.addMarker(
                        MarkerOptions()
                            .position(marker)
                            .title("$name($transportationType)")
                            .snippet("$date, $time")
                    )

                    //Zooming to the coordinates
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker, 9f))
                }

            }

            /*

            //Setting up the latitudes and longitudes
            val marker = LatLng(-33.8688,151.2093)
            //Positioning the map
            mMap.addMarker(MarkerOptions().position(marker).title("Sydney"))
            //Zooming to the coordinates
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker, 10f))

             */

        }

    }



    //Function to setup the suffix for the date
    fun getDayOfMonthSuffix(n: Int): String {
        if (n % 100 / 10 == 1) {
            return "th"
        } else
            when (n % 10) {
                1 -> return "st"
                2 -> return "nd"
                3 -> return "rd"
                else -> return "th"
            }

    }




}

