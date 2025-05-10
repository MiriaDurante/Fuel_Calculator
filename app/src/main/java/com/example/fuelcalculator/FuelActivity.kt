package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class FuelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fuel)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets}

            val btnFuel = findViewById<Button>(R.id.btn_FuelCost)
            val FuelEditText = findViewById<TextInputEditText>(R.id.textInputEditTextFuel)

            btnFuel.setOnClickListener {
                val FuelValue = FuelEditText.text.toString()

                if (FuelValue.isEmpty()) {
                    FuelEditText.error = "Please enter a distance."
                } else {
                    try {
                        val km = FuelValue.toDouble()
                        if (km > 0) {
                            val intent = Intent(this, CarEfficiencyActivity::class.java)
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