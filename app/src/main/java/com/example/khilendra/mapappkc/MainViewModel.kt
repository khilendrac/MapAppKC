package com.example.khilendra.mapappkc

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.khilendra.mapappkc.data.LocationMelbourne
import com.example.khilendra.mapappkc.source.DataRepo
import com.example.khilendra.mapappkc.source.JsonParsing

class MainViewModel: ViewModel() {
     lateinit var locations: ArrayList<LocationMelbourne>




     //Getting locations details from the repository and passing the class JsonParsing
    private val dataRepository: DataRepo = DataRepo(JsonParsing())

    init {
        //This is to initialize the model
        fetchLocations("e")
    }
    fun fetchLocations(locationName: String) {
        //Get locations from DataRepo class
        locations = dataRepository.getLocations(locationName)

    }





}