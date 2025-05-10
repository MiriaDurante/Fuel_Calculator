package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class KmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.km_activity)

        val kmbutton = findViewById<Button>(R.id.btn_Km)
        val kmEditText = findViewById<TextInputEditText>(R.id.textInputEditTextKm)

        kmbutton.setOnClickListener {
            val kmValue = kmEditText.text.toString()

            if (kmValue.isEmpty()) {
                kmEditText.error = "Please enter a distance."
            } else {
                try {
                    val km = kmValue.toDouble()
                    if (km > 0) {
                        val intent = Intent(this, FuelActivity::class.java)
                        startActivity(intent)
                    } else {

                        kmEditText.error = "Distance must be a positive number."
                    }
                } catch (e: NumberFormatException) {

                    kmEditText.error = "Please enter a valid number."
                }
            }
        }
    }
}
