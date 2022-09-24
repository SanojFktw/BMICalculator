package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var etWeightNumber: EditText
    private lateinit var etHeightNumber: EditText
    private lateinit var tvBMIValue: TextView
    private lateinit var tvStatus: TextView
    private lateinit var btnCalculate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etWeightNumber = findViewById(R.id.editTextNumberDecimal)
        etHeightNumber = findViewById(R.id.editTextNumberDecimal2)
        tvBMIValue = findViewById(R.id.tvBmiNumber)
        tvStatus = findViewById(R.id.tvCondition)
        btnCalculate = findViewById(R.id.btnClick) as Button

        btnCalculate.setOnClickListener {
            ComputeBMI()
        }
    }

    private fun updatetvStatus(Bmi: Double) {
        val bmiD = when (Bmi) {
            in 0.0..18.5 -> "You are Underweight"
            in 18.5..24.9 -> "You are Healthy"
            in 24.9..29.9 -> "You are overweight"
            else -> "You are obesse"
        }
        tvStatus.text = bmiD
    }

    private fun ComputeBMI(){
        if(etWeightNumber.text.isEmpty()){
            tvStatus.text=""
            return
        }

        val weightValue = etWeightNumber.text.toString().toDouble()
        val heightValue = etHeightNumber.text.toString().toDouble()
        val bmiValue =  weightValue / (heightValue * heightValue)

        tvStatus.text = "%.1f".format(bmiValue)
        updatetvStatus(bmiValue)


    }
}