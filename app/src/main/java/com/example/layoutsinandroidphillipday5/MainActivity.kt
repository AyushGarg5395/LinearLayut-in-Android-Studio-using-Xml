package com.example.layoutsinandroidphillipday5

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnApply = findViewById<Button>(R.id.btnApply)
        val etFirstName = findViewById<EditText>(R.id.etFirstName)
        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etBirthDate = findViewById<EditText>(R.id.etBirthDate)
        val etCountry = findViewById<EditText>(R.id.etCountry)
        val btnCount = findViewById<Button>(R.id.btnCount)
        val tvCount = findViewById<TextView>(R.id.tvCount)
        val etFirstNumber = findViewById<EditText>(R.id.etFirstnumber)
        val etSecondNumber = findViewById<EditText>(R.id.etSecondNumber)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        // *****  for form information of user to fill *********
        btnApply.setOnClickListener {
            val firstName= etFirstName.text.toString()
            val lastName = etLastName.text.toString()
            val birthDate = etBirthDate.text.toString()
            val country = etCountry.text.toString()
            Log.d("MainActivity", "$firstName $lastName, born on $birthDate, from $country just applied to the formular")
        }

        //****************  Counter for count button   *************
        var count = 0
        btnCount.setOnClickListener {
            count++
            tvCount.text = "Let's count together : $count"
        }

        //********** calculator to add two numbers *************
        btnAdd.setOnClickListener {
            val firstNumber = etFirstNumber.text.toString().toInt()
            val secondNumber = etSecondNumber.text.toString().toInt()
            val result = firstNumber + secondNumber
            tvResult.text = result.toString()
        }
    }
}