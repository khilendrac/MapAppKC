package com.example.khilendra.mapappkc.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.khilendra.mapappkc.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions



class GoogleMapFragment : Fragment() {

    private lateinit var mMap : GoogleMap
    private var mapReady = false



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_google_map, container, false)

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
        //Setting up the latitudes and longitudes
        val marker = LatLng(-33.8688,151.2093)
        //Positioning the map
        mMap.addMarker(MarkerOptions().position(marker).title("Sydney"))
        //Zooming to the coordinates
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker, 10f))


    }

}