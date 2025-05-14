package com.example.fuelcalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_EFFICIENCY = "CarEfficiency.Key"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val km =intent.getFloatExtra(KEY_KM,0f)
        val fuel = intent.getFloatExtra(KEY_FUEL, 0f)
        val efficiency = intent.getFloatExtra(KEY_EFFICIENCY,0f)


    }
}