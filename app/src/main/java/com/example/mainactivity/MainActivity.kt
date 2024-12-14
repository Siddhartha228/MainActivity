package com.example.mainactivity

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val fullName = findViewById<EditText>(R.id.fullName)
        val email = findViewById<EditText>(R.id.email)
        val genderGroup = findViewById<RadioGroup>(R.id.genderGroup)
        val countrySpinner = findViewById<Spinner>(R.id.countrySpinner)
        val cityAutoComplete = findViewById<AutoCompleteTextView>(R.id.cityAutoComplete)
        val termsCheckBox = findViewById<CheckBox>(R.id.termsCheckBox)
        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
            val selectedGenderId = genderGroup.checkedRadioButtonId
            val selectedGender = findViewById<RadioButton>(selectedGenderId).text.toString()
            val selectedCountry = countrySpinner.selectedItem.toString()
            val selectedCity = cityAutoComplete.text.toString()

            if (termsCheckBox.isChecked) {
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("fullName", fullName.text.toString())
                intent.putExtra("email", email.text.toString())
                intent.putExtra("gender", selectedGender)
                intent.putExtra("country", selectedCountry)
                intent.putExtra("city", selectedCity)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please agree to the terms and conditions", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
