package com.example.exercise3kevin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            calculatePremium()
        }
    }

    private fun calculatePremium(){
        //TODO calculate insurance premium
        var premium : Int =0

        //position = index of an item selected by user
        val age: Int =  spinnerAge.selectedItemPosition

        premium += when (age){
            0 ->60
            1 ->70
            2 ->90
            3 ->120
            4 ->150
            else ->150
        }

        //ID of a radio buttin checked by user
        val gender:Int  = radioGroupGender.checkedRadioButtonId

        if(gender == R.id.radioButtonMale) {
            premium += when (age){
                0 ->0
                1 ->50
                2 ->100
                3 ->150
                4 ->200
                else ->200
            }
        }
        //Boolean value
        val smoker:Boolean = checkBoxSmoker.isChecked
        if(smoker== true){
            premium += when (age){
                0 ->0
                1 ->100
                2 ->150
                3 ->200
                4 ->250
                else ->300
            }
        }
        textViewPremium.text= String.format("%s %d",getString(R.string.insurance_premium),premium)
    }

    fun resetInput(view:View?){
        //TODO clear all inout and outputs
        spinnerAge.setSelection(0)
        textViewPremium.text= String.format("%s",getString(R.string.insurance_premium))
        radioGroupGender.clearCheck()
        checkBoxSmoker.isChecked=false


    }
}

