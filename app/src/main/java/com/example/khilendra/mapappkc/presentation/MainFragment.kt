package com.example.khilendra.mapappkc.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.khilendra.mapappkc.R


class MainFragment : Fragment() {


    //data to be passed to another fragment
    private var transportType = ""
    private var express = ""
    private var mykiTopup = ""

    //Flag to check if the validation of the screen is successful
    private var validationSuccessful = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        //Getting the button from the view
        val btnGenerate = view.findViewById<ImageButton>(R.id.btnGenerate)

       //Implementing the logic after the generate button is clicked by the user
        btnGenerate.setOnClickListener {
            validate(view)
            if(validationSuccessful) {
                findNavController().navigate(R.id.action_mainFragment_to_googleMapFragment)
            }
        }

        return view
    }




    //Function to validate the input from the screen
    private fun validate(view: View) {

        //flags for logic
        var flag1 = true
        var flag2 = true
        var flag3 = true

        // variables assigned with the ids
        val btnGen = view.findViewById<View>(R.id.btnGenerate) as ImageButton
        val radioGrp1 = view.findViewById<View>(R.id.radioGroupTransportType) as RadioGroup
        val radioGrp2 = view.findViewById<View>(R.id.radioGroupExpress) as RadioGroup
        val radioGrp3 = view.findViewById<View>(R.id.radioGroupMyki) as RadioGroup
        val errorText = view.findViewById<View>(R.id.errorMessage) as TextView


        errorText.setText("")
        //Validating Train or Tram Radio Button Selection
        val checkedRadioTransportTypeId = radioGrp1.checkedRadioButtonId
        val trainOrTram = view.findViewById<RadioButton>(checkedRadioTransportTypeId)
        if(trainOrTram == null) {
            //validation for Transport Type: Train or Tram to be selected
            flag1 = false
        }else {
            flag1 = true
            transportType = trainOrTram.text as String
            //Displayed the value on the screen to test it
            //errorText.setText(transportType)
        }

        //Validating Express or not
        val checkedRadioExpressId = radioGrp2.checkedRadioButtonId
        val expressOrNot = view.findViewById<RadioButton>(checkedRadioExpressId)
        if(expressOrNot == null) {
            //validation for Express: Yes or No to be selected
            flag2 = false
        }else {
            flag2 = true
            express = expressOrNot.text as String
            //Displayed the value on the screen to test it
            //errorText.setText(express)
        }


        //Validating Myki Top up Present of not
        val checkedRadioMykiId = radioGrp3.checkedRadioButtonId
        val mykiOrNot = view.findViewById<RadioButton>(checkedRadioMykiId)
        if(mykiOrNot == null) {
            //validation for Myki Topup Station: Yes or No to be selected
            flag3 = false
        }else {
            flag3 = true
            mykiTopup = mykiOrNot.text as String
            //Displayed the value on the screen to test it
            //errorText.setText(mykiTopup)
        }


        if (flag1 && flag2 && flag3) {
            //Validation is successful
            //Setting up the values in order to pass to google map fragment
            //val bundle = Bundle()
            //bundle.putString("data1",transportType)
            //bundle.putString("data2", express)
            //bundle.putString("data3", mykiTopup)

            //Calling the fragment and passing the arguments
            //val fragmentGoogleMap = GoogleMapFragment()
            //fragmentGoogleMap.arguments = bundle
            //fragmentManager?.beginTransaction()?.replace(R.id.container, fragmentGoogleMap)?.commit()
            validationSuccessful = true
        } else
        //Setting up error message on the screen as per the error occurance
            validationSuccessful = false
            if (!flag1) {
                errorText.setText("Please select Transport Type!")
            }else if (!flag2) {
                errorText.setText("Please select Express or Not!")
            }else if (!flag3) {
                errorText.setText("Please select Myki Topup or Not!")
            }

    }

}