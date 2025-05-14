package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

const val KEY_KM = "KmActivity.kmkey"

class FuelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fuel)

            val btnFuel = findViewById<Button>(R.id.btn_FuelCost)
            val FuelEditText = findViewById<TextInputEditText>(R.id.textInputEditTextFuel)
            val km = intent.getFloatExtra(KEY_KM,0f)

            btnFuel.setOnClickListener {
                val FuelValue = FuelEditText.text.toString()

                if (FuelValue.isEmpty()) {
                    FuelEditText.error = "Please enter a distance."
                } else {
                    try {
                        val fuel = FuelValue.toDouble()
                        if (fuel > 0) {
                            val intent = Intent(this, CarEfficiencyActivity::class.java)
                            intent.putExtra(KEY_FUEL,fuel)
                            intent.putExtra(KEY_KM)
                            startActivity(intent)
                        } else {

                            FuelEditText.error = "Please enter the fuel price."
                        }
                    } catch (e: NumberFormatException) {

                        FuelEditText.error = "Please enter a valid number."
                    }
                }

        }
    }
}