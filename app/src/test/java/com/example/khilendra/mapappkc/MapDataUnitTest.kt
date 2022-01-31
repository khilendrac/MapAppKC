package com.example.khilendra.mapappkc

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.khilendra.mapappkc.data.LocationMelbourne
import com.example.khilendra.mapappkc.source.JsonParsing
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MapDataUnitTest {

    lateinit var mvm:MainViewModel

    @get: Rule
    var rule: TestRule = InstantTaskExecutorRule()



    @Test
    fun confirmFlinders_outputsFlinders () {
        //This function tests for the location given
        var location: LocationMelbourne = LocationMelbourne(
            0,
            "2021-07-03T09:10:00.000Z",
            "Flinders",
            -37.8181755,
            144.9661256,
            "",
            ""
        )
        assertEquals("Flinders", location.toString())
    }



    @Test
    fun searchForFlinders_returnsFlinders() {
        //This function will search for Flinders
        givenAFeedOfMapDataAreAvaliable()
        whenSearchForFlinders()
        thenResultContainsFlinders()
    }
    private fun givenAFeedOfMapDataAreAvaliable() {
        mvm = MainViewModel()
    }

    private fun whenSearchForFlinders() {
        mvm.fetchLocations("Flinders")
    }


    //This test is not working since I need to pass context to the JsonParsing class in order to use json file from assets
    private fun thenResultContainsFlinders() {
        var flindersFound = false
        var locs: ArrayList<LocationMelbourne> = mvm.locations

        locs.forEach {
            assertNotNull(it)
            assertTrue(locs.size > 0)
            if (it.typeId ==0 && it.departureTime=="2021-07-03T09:10:00.000Z" && it.name=="Flinders" &&
                it.latitude==-37.8181755 && it.longitude==144.9661256 && it.isExpress == "" && it.hasMyKiTopUp == ""
            ) {
                flindersFound = true
            }
            assertTrue(flindersFound)
        }
    }


    @Test
    fun searchForGarbage_returnsNothing() {
        //This function looks for garbage data found
        givenAFeedOfMapDataAreAvaliable()
        whenISearchForGarbage()
        thenIGetZeroResults()

    }



    private fun whenISearchForGarbage() {
        mvm.fetchLocations("sdfasdfgerjkrghkjasdf")
    }

    private fun thenIGetZeroResults() {
        var garbageFound = true

        var locs: ArrayList<LocationMelbourne> = mvm.locations

        locs.forEach {
            assertNotNull(it)
            assertTrue(locs.size > 0)
            if (it.name=="sdfasdfgerjkrghkjasdf") {
                garbageFound = false
            }
            assertTrue(garbageFound)
        }
    }



}