package com.example.fuelcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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

        val km: Float =intent.getFloatExtra(KEY_KM,0f)
        val tvKm = findViewById<TextView>(R.id.tv_km)

        val fuel: Float = intent.getFloatExtra(KEY_FUEL, 0f)
        val tvFuel = findViewById<TextView>(R.id.tv_fuel)

        val efficiency: Float = intent.getFloatExtra(KEY_EFFICIENCY,0f)
        val tvConsumption = findViewById<TextView>(R.id.tv_consumption)

        val result: Float = (km*fuel)/efficiency
        val tvResult = findViewById<TextView>(R.id.result)

        tvResult.text = "€ %.2f".format(result)
        tvKm.text = "%.2f".format(km)
        tvFuel.text = ("€ " +
                "%.2f").format(fuel)
        tvConsumption.text = "%.2f".format(efficiency)



    }
}