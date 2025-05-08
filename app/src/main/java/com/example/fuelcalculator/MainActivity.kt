package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val startbutton = findViewById<Button>(R.id.btn_start)

        startbutton.setOnClickListener {
            val intent = Intent(this, KmActivity::class.java)
            startActivity(intent)
        }


    }
}