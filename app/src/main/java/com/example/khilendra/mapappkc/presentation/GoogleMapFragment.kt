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
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import java.time.LocalDate

import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

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

    private lateinit var testText: String


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


        //Configuring the view model
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        //Getting locations from the view model
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


    private fun updateMap() {

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

        if(mapReady) {

            locations.forEach {
                location ->
                latitude = location.latitude
                longitude = location.longitude
                name = location.name
                departureTime = location.departureTime
                isExpress = location.isExpress
                hasMyki = location.hasMyKiTopUp
                transType = location.typeId


                if (transType == 0) {
                    transportationType = "Train"

                } else {
                    transportationType = "Tram"
                }

                if(isExpress == "") {
                    isExpress = "false"
                }
                if(hasMyki == "") {
                    hasMyki = "false"
                }

                var formatter = DateTimeFormatter.ofPattern("dd-MMM-YYYY")
                var formattedDate = currentDate.format(formatter)

                var formattedTime = currentTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT))


                if(transportType == transportationType && expressOrNot == isExpress && hasMykiTopUpOrNot == hasMyki) {
                    //Setting up the latitudes and longitudes
                    val marker = LatLng(latitude,longitude)
                    //Positioning the map

                    mMap.addMarker(
                        MarkerOptions()
                            .position(marker)
                            .title("$name($transportationType)")
                            .snippet("$formattedDate, $formattedTime")
                    )

                    //Zooming to the coordinates
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker, 11f))

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

}

