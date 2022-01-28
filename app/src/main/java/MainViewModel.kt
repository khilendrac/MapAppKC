import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.khilendra.mapappkc.data.LocationMelbourne
import com.example.khilendra.mapappkc.source.DataRepo
import com.example.khilendra.mapappkc.source.JsonParsing

class MainViewModel: ViewModel() {
     lateinit var locations: ArrayList<LocationMelbourne>


    //var locationService: LocationService = LocationService()

    private val dataRepository: DataRepo = DataRepo(JsonParsing())

    init {
        fetchLocations("e")
    }
    fun fetchLocations(locationName: String) {
        locations = dataRepository.getLocations()
        //locations = locationService.fetchLocations(locationName)
    }

}