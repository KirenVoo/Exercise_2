package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var imageProfile : ImageView
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        buttonCalculate.setOnClickListener{bmiCalculator()}

        val buttonReset: Button = findViewById(R.id.buttonReset)
        buttonReset.setOnClickListener{resetText()}
    }

    private fun bmiCalculator(){
        val weight: Double = editTextWeight.text.toString().toDouble()
        val height: Double = editTextHeight.text.toString().toDouble()
        val imageProfile : ImageView = findViewById(R.id.imageViewProfile)

        var bmi = String.format("%.2f", weight / ((height / 100) * (height / 100)))

        if(bmi.toDouble() < 18.5){
            val imageProfile:ImageView  = findViewById(R.id.imageViewProfile)
            imageProfile.setBackgroundResource(R.drawable.under)
            textViewBMI.text = "Underweight"
        }else if (bmi.toDouble() >18.5 && bmi.toDouble() <= 24.9){
            val imageProfile:ImageView = findViewById(R.id.imageViewProfile)
            imageProfile.setBackgroundResource(R.drawable.normal)
            textViewBMI.text = "Normal"
        }else if(bmi.toDouble() > 25){
            val imageProfile:ImageView = findViewById(R.id.imageViewProfile)
            imageProfile.setBackgroundResource(R.drawable.over)
            textViewBMI.text = "Overweight"
        }
        else{
            val imageProfile: ImageView = findViewById(R.id.imageViewProfile)
            imageViewProfile.setBackgroundResource(R.drawable.empty)
        }

    }

    private fun resetText(){
        editTextWeight.text = null
        editTextHeight.text = null
        imageViewProfile.setBackgroundResource(R.drawable.empty)
        textViewBMI.text = "BMI: "
    }
}
