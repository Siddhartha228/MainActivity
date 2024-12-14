package com.example.mainactivity

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)

        val welcomeMessage = findViewById<TextView>(R.id.welcomeMessage)
        val emailDisplay = findViewById<TextView>(R.id.emailDisplay)
        val genderDisplay = findViewById<TextView>(R.id.genderDisplay)
        val countryDisplay = findViewById<TextView>(R.id.countryDisplay)
        val cityDisplay = findViewById<TextView>(R.id.cityDisplay)

        val fullName = intent.getStringExtra("fullName")
        val email = intent.getStringExtra("email")
        val gender = intent.getStringExtra("gender")
        val country = intent.getStringExtra("country")
        val city = intent.getStringExtra("city")

        welcomeMessage.text = "Welcome, $fullName!"
        emailDisplay.text = "Email: $email"
        genderDisplay.text = "Gender: $gender"
        countryDisplay.text = "Country: $country"
        cityDisplay.text = "City: $city"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
