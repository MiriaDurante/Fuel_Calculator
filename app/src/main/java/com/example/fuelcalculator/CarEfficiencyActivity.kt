package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

const val KEY_FUEL = "FuelActivity.key"

class CarEfficiencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_car_efficiency)

        val carButton = findViewById<Button>(R.id.btn_Car)
        val carEditText = findViewById<TextInputEditText>(R.id.textInputEditTextCar)
        val km = intent.getFloatExtra(KEY_KM,0f)
        val fuel = intent.getFloatExtra(KEY_FUEL,0f)

        carButton.setOnClickListener {
            val carValue = carEditText.text.toString()

            if (carValue.isEmpty()) {
                carEditText.error = "Please enter your car's fuel consumption."
            } else {
                try {
                    val consumption = carValue.toDouble()
                    if (consumption > 0) {

                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra("CAR_CONSUMPTION", consumption)
                        intent.putExtra(KEY_EFFICIENCY,consumption)
                        intent.putExtra(KEY_FUEL)
                        intent.putExtra(KEY_KM)
                        startActivity(intent)
                    } else {
                        carEditText.error = "Fuel consumption must be a positive number."
                    }
                } catch (e: NumberFormatException) {
                    carEditText.error = "Please enter a valid number."
                }
            }
        }
    }
}

