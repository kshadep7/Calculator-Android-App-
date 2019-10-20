package com.app.calculatorapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //    variables for result and new number entered
    private lateinit var result: EditText
    private lateinit var newNumber: EditText

    //    Variables for operands
    private var operand1: Double? = null
    private var operand2: Double = 0.0
    private var pendingOperation = "="


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById<EditText>(R.id.result)
        newNumber = findViewById<EditText>(R.id.newNumber)

//        calculator buttons
        var button0: Button = findViewById(R.id.button0)
        var button1: Button = findViewById(R.id.button1)
        var button2: Button = findViewById(R.id.button2)
        var button3: Button = findViewById(R.id.button3)
        var button4: Button = findViewById(R.id.button4)
        var button5: Button = findViewById(R.id.button5)
        var button6: Button = findViewById(R.id.button6)
        var button7: Button = findViewById(R.id.button7)
        var button8: Button = findViewById(R.id.button8)
        var button9: Button = findViewById(R.id.button9)
        var buttonAdd: Button = findViewById(R.id.buttonAdd)
        var buttonSub: Button = findViewById(R.id.buttonSub)
        var buttonMul: Button = findViewById(R.id.buttonMultiply)
        var buttonDiv: Button = findViewById(R.id.buttonDivide)
        var buttonMod: Button = findViewById(R.id.buttonMod)
        var buttonEqual: Button = findViewById(R.id.buttonEqual)


    }
}
