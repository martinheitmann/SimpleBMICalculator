package com.app.simplebmicalculator

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_bmi_calc.*
import java.text.DecimalFormat
import kotlin.math.pow

class BmiCalcActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_calc)

        button_calculate.setOnClickListener { showResults() }
    }

    fun calculateBmi(height: Double?, weight: Double?) : Double {
        if(height == null || weight == null){
            return -1.0
        }

        var mHeight = height/100

        var result = (weight/(mHeight.pow(2)))

        var stringResult = String.format("%.2f", result)
        return stringResult.toDouble()
    }

    fun showResults(){
        var height = editText_height.text.toString().toDoubleOrNull()
        var weight = editText_weight.text.toString().toDoubleOrNull()

        var result = calculateBmi(height, weight)

        if(result < 0){
            if (weight == null){
                textInputLayout_weight.error = "You have to input a valid number!"
            }
            if (height == null){
                textInputLayout_height.error = "You have to input a valid number!"
            }
        }
        else {
            linLayout_results.visibility = View.VISIBLE
            textView_results_num.text = result.toString()
            setColorAndDescription(result)
        }
    }

    fun setColorAndDescription(result: Double){
        lateinit var description: String
        lateinit var color: String

        if(result < 15){
            description =
                    "A BMI of lower than 15 indicates very severe underweight, and should be evaluated by " +
                    "a medical professional. "
            color = "#ff0000"
        }
        if(result > 15 && result < 16){
            description =
                    "A BMI of lower than 16 indicates severe underweight, and should be evaluated by " +
                    "a medical professional. "
            color = "#ff0000"
        }
        if(result >= 16 && result < 18.5){
            description =
                    "A BMI of lower than 18.5 indicates underweight. "
            color = "#ffa500"
        }
        if(result >= 18.5 && result < 25){
            description =
                    "A BMI ranging between 18.5 and 25 is considered a normal and healthy weight."
            color = "#00FF00"
        }
        if(result >= 25 && result < 30){
            description =
                    "A BMI of over 25 is considered overweight."
            color = "#ffa500"
        }
        if(result >= 30 && result < 35){
            description =
                    "A BMI of over 30 is considered moderately obese."
            color = "#ff0000"
        }
        if(result >= 35 && result < 40){
            description =
                    "A BMI of over 35 is considered severely obese."
            color = "#ff0000"
        }
        if(result >= 40 && result < 45){
            description =
                    "A BMI of over 40 is considered very severely obese."
            color = "#ff0000"
        }
        if(result >= 45 && result < 50){
            description =
                    "A BMI of over 45 is considered morbidly obese."
            color = "#ff0000"
        }
        if(result >= 50 && result < 60){
            description =
                    "A BMI of over 50 is considered super obese."
            color = "#ff0000"
        }
        if(result > 60 ){
            description =
                    "A BMI of over 60 is considered hyper obese."
            color = "#ff0000"
        }

        textView_result_description.text = description
        textView_results_num.setTextColor(Color.parseColor(color))

    }
}
