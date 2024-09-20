package com.cs407.calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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

        val additionButton = findViewById<Button>(R.id.addition);
        val multiplicationButton = findViewById<Button>(R.id.multiplication);
        val subtractionButton = findViewById<Button>(R.id.subtraction);
        val divisionButton = findViewById<Button>(R.id.division);

        additionButton.setOnClickListener {
            val inputOne = findViewById<EditText>(R.id.firstInput).text.toString().toDouble();
            val inputTwo = findViewById<EditText>(R.id.secondInput).text.toString().toDouble();
            val result = inputOne + inputTwo;
            val intent = Intent(this, CalculatorResult::class.java)
            intent.putExtra("CALCULATION_RESULT", result)
            startActivity(intent)
        }

        multiplicationButton.setOnClickListener {
            val inputOne = findViewById<EditText>(R.id.firstInput).text.toString().toDouble();
            val inputTwo = findViewById<EditText>(R.id.secondInput).text.toString().toDouble();
            val result = inputOne * inputTwo;
            val intent = Intent(this, CalculatorResult::class.java)
            intent.putExtra("CALCULATION_RESULT", result)
            startActivity(intent)
        }

        subtractionButton.setOnClickListener {
            val inputOne = findViewById<EditText>(R.id.firstInput).text.toString().toDouble();
            val inputTwo = findViewById<EditText>(R.id.secondInput).text.toString().toDouble();
            val result = inputOne - inputTwo;
            val intent = Intent(this, CalculatorResult::class.java)
            intent.putExtra("CALCULATION_RESULT", result)
            startActivity(intent)
        }

        divisionButton.setOnClickListener {
            val inputOne = findViewById<EditText>(R.id.firstInput).text.toString().toDouble();
            val inputTwo = findViewById<EditText>(R.id.secondInput).text.toString().toDouble();
            if(inputTwo.equals(0.0)) {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                return@setOnClickListener;
            }
            val result = inputOne / inputTwo;
            val intent = Intent(this, CalculatorResult::class.java)
            intent.putExtra("CALCULATION_RESULT", result)
            startActivity(intent)
        }

    }
}